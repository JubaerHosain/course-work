#include<bits/stdc++.h>
using namespace std;
#define endl    '\n'
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<int>> vii;

/*****user defined function*****/

bool valid(stack<char> stk, string &input, int i) {
    int n = input.length();
    while(!stk.empty() && i < n) {
        if(stk.top() == input[i])
            stk.pop(), i++;
        else 
            return false;
    }
    return stk.empty() && i == n;
}

void solve_problem() {
    string input;
    cin >> input;

    stack<char> stk;

    for(int i = 0; i < input.length()-1; i++) {
        char ch = input[i];
        stk.push(ch);
        if(valid(stk, input, i+1)) {
            cout << "String is accepted." << endl;
            return;
        }
    }

    cout << "String is not accepted." << endl;
}

/*****main function*****/
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cout << fixed << showpoint; 
    cout << setprecision(16);

    int test = 1;   
    // cin >> test;
    while(test--) solve_problem();

    return 0;
} 