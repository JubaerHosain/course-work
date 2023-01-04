#include<bits/stdc++.h>
using namespace std;
typedef pair<int, pair<char, char>> pii;

const int N = 20;
set<int> graph[N];
stack<int> stk;
bool used[N], on_stk[N];

pii parse_transaction(string s) {
    char mode = s[0];

    int i = 1;
    string num = "";
    while(isdigit(s[i])) {
        num.push_back(s[i]);
        i += 1;
    }
    i += 1;

    char acc = s[i];

    return {stoi(num), {mode, acc}};
}

bool cycle(int u) {
    used[u] = true;
    on_stk[u] = true;
    stk.push(u);

    for(int v: graph[u]) {
        if(!used[v]) {
            if(cycle(v))
                return true;
        } else if(on_stk[v]) {
            stk.push(v);
            return true;
        }
    }

    on_stk[stk.top()] = false;
    stk.pop();

    return false;
}


// r -> w
// w -> r,w

int main() {
    freopen("input.txt", "r", stdin);

    // {num, {r/w, x/y}}
    vector<pii> transactions;
    string current;
    while(cin >> current) {
        transactions.push_back(parse_transaction(current));
    }

    for(auto it: transactions) 
        cout << it.second.first << it.first << "(" << it.second.second << ")" << endl; 
    

    // make adjacency list
    int n = transactions.size();
    for(int i = 0; i < n; i++) {
        pii a = transactions[i];
        for(int j = i+1; j < n; j++) {
            pii b = transactions[j];

            // different account
            if(a.second.second != b.second.second)
                continue;
            
            // self loop
            if(a.first == b.first)
                continue;

            // both are reading
            if(a.second.first == 'r' and b.second.first == 'r')
                continue;

            int u = a.first, v = b.first;
            graph[u].insert(v);
        }
    }

    for(int i = 1; i < N; i++) {
        if(graph[i].size()) {
            cout << i << " -> ";
            for(int j: graph[i])
                cout << j << " ";
            cout << endl;
        }
    }

    for(int u = 1; u < N; u++) {
        if(cycle(u)) {
            cout << "Not serializable" << endl;
            return 0;
        }
    }

    cout << "Serializable" << endl;

    return 0;
}

