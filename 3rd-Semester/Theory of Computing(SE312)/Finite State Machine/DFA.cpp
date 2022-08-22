#include<bits/stdc++.h>
using namespace std;
#define endl    '\n'
typedef long long ll;
typedef vector<vector<int>> vii;
 
/*****User defined function*****/

void solve_problem() {
    // number of states
    int noOfState;
    cin >> noOfState;

    // transition table over alphabet {0, 1}
    vii table(noOfState+1, vector<int>(2));
    for(int i = 1; i <= noOfState; i++) {
        cin >> table[i][0] >> table[i][1];
    }

    // starting state
    int start;
    cin >> start;

    // number of final state
    int noOfFinal;
    cin >> noOfFinal;

    // final states
    set<int> finals;
    for(int i = 1; i <= noOfFinal; i++) {
        int state;
        cin >> state;
        finals.insert(state);
    }


    string str;
    cin >> str;

    int current = start;
    for(char c: str) {
        int next = table[current][c-'0'];
        cout << current << " to " << next << " using " << c-'0' << endl;
        current = next;
    }

    if(finals.count(current)) {
        cout << "The string is accepted by the given language." << endl;
    } 
    else {
        cout << "The string is not accetpted by the given language." << endl;
    }
}
 
/*****main function*****/
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif 
 
    cout << fixed << showpoint;
    cout << setprecision(5);
    
    solve_problem();
    
    return 0;
} 
