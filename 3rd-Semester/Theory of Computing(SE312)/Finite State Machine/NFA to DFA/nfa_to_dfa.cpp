#include<bits/stdc++.h>
using namespace std;
#define endl          '\n'//notforinter
#define all(v)        v.begin(), v.end()
#define print(var)    cout << var << endl
#define rep(i, s, n)  for(int i = s; i <= n; i++)
#define rrep(i, n, s) for(int i = n; i >= s; i--)
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<vector<int>> vii;
 
/*****User defined function*****/
const int N = 100+5;

set<int> nfa[N][2];

// {{set, {set, set}}
vector<pair<set<int>, pair<set<int>, set<int>>>> dfa;
set<set<int>> visited;
int numberOfState;
int start_state;
set<int> final_states;

void print_dfa() {
    for(auto it: dfa) {
        // state 
        if(it.first.size() == 0)
            it.first.insert(0);
        cout << "{";
        for(auto q: it.first) 
            cout << q << ",";
        cout << "}";


        cout << " | ";


        if(it.second.first.size() == 0) 
            it.second.first.insert(0);
        cout << "{";
        for(auto q: it.second.first) 
            cout << q << ",";
        cout << "}";

        cout << " | ";


        cout << "{";
        for(auto q: it.second.second) 
            cout << q << ",";
        cout << "}";


        cout << endl;
    }
} 

void read_nfa() {
    cin >> numberOfState;

    // read transition table of nfa 
    int cnt;
    for(int i = 1; i <= numberOfState; i++) {
        // number of states via 0 from i
        cin >> cnt;
        for(int j = 1; j <= cnt; j++) {
            int q;
            cin >> q;
            nfa[i][0].insert(q);
        }

        // number of states via 1 from i
        cin >> cnt;
        for(int j = 1; j <= cnt; j++) {
            int q;
            cin >> q;
            nfa[i][1].insert(q);
        }
    }

    // read start state
    cin >> start_state;

    // read number of final state
    int noOfFinal;
    cin >> noOfFinal;
    
    // read final states
    for(int i = 0; i < noOfFinal; i++) {
        int q;
        cin >> q;
        final_states.insert(q);
    }
}
 
void convert_nfa_to_dfa() {
    // insert starting state 
    set<int> start;
    start.insert(start_state);

    queue<set<int>> q;
    q.push(start);
    while(!q.empty()) {
        set<int> curr = q.front();
        q.pop();
    
        //cout << "Curr size: " << curr.size() << endl;

        // if current state is already visited
        if(visited.count(curr)) continue;

        visited.insert(curr);

        set<int> next0;
        set<int> next1;

        for(int q: curr) {
            //cout << "q-> " << q << endl;
            // null state
            if(q == 0) continue;

            // via 0
            for(int p: nfa[q][0]) {
               // cout << "p->0: " << p << endl;
                if(p == 0) continue;
                next0.insert(p);
            }

            // via 1
            for(int p: nfa[q][1]) {
                //cout << "p->1: " << p << endl;
                if(p == 0) continue;
                next1.insert(p);
            }
        }

        q.push(next0);
        q.push(next1);
        dfa.push_back({curr, {next0, next1}});
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
 
    read_nfa();
    convert_nfa_to_dfa();
    print_dfa();
 
    return 0;
} 