#include<bits/stdc++.h>
using namespace std;
#define endl    '\n'
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<int>> vii;
 
/*****User defined function*****/
int total_allocated(vector<vector<int>> &allocated_res, int res_no) {
    // res_no = resource number, colum 
    int sum = 0;
    for(int i = 0; i < allocated_res.size(); i++) 
        sum += allocated_res[i][res_no];
    return sum;
}

bool is_possible(vector<int> &current_need, vector<int> &available_res) {
    for(int i = 0; i < current_need.size(); i++) {
        if(current_need[i] > available_res[i])
            return false;
    }
    return true;
}

void bankers_algorithm() {
    // all input would taken from file

    int num_of_res;
    cin >> num_of_res;

    vector<int> total_resources(num_of_res);
    for(int i = 0; i < num_of_res; i++)
        cin >> total_resources[i];

    int num_of_process;
    cin >> num_of_process;

    vector<vector<int>> allocated_res(num_of_process, vector<int>(num_of_res));
    for(int i = 0; i < num_of_process; i++) {
        for(int j = 0; j < num_of_res; j++)
            cin >> allocated_res[i][j];
    }

    vector<vector<int>> max_need(num_of_process, vector<int>(num_of_res));
    for(int i = 0; i < num_of_process; i++) {
        for(int j = 0; j < num_of_res; j++)
            cin >> max_need[i][j];
    }

    vector<int> available_res(num_of_res);
    for(int i = 0; i < num_of_res; i++) {
        available_res[i] = total_resources[i] - total_allocated(allocated_res, i);
    }

    vector<vector<int>> current_need(num_of_process, vector<int>(num_of_res));
    for(int i = 0; i < num_of_process; i++) {
        for(int j = 0; j < num_of_res; j++)
            current_need[i][j] = max_need[i][j] - allocated_res[i][j];
    }

    bool updated = true;
    vector<bool> in_safe(num_of_process, false);
    vector<int> safe_states;
    while(updated) {
        updated = false;
        for(int i = 0; i < num_of_process; i++) {
            // check process i is becomes safe or not
            if(in_safe[i]) continue;

            if(is_possible(current_need[i], available_res)) {
                safe_states.push_back(i);
                in_safe[i] = true;
                updated = true;
                // free allocated resources for i th process
                for(int j = 0; j < num_of_res; j++) 
                    available_res[j] += allocated_res[i][j];
            }
        }   
    }
    
    if(safe_states.size() != num_of_process) {
        cout << "System is in deadlock" << endl;
    } 
    else {
        cout << "System is safe" << endl;
        cout << "Process sequence: ";
        for(int i = 0; i < num_of_process; i++) 
            cout << safe_states[i] << " "; 
        cout << endl;
    }
}

/*****main function*****/
int main() {
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    #endif
 
    bankers_algorithm();
 
    return 0;
} 
