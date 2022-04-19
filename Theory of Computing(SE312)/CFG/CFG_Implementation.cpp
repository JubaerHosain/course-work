#include<bits/stdc++.h>
using namespace std;
#define endl    '\n'
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<int>> vii;

/*****user defined function*****/

bool equals(string &str, string &pat) {
    if(str.length() != pat.length())
        return false;
    for(int i = 0; i < str.length(); i++)
        if(str[i] != pat[i])
            return false;
    return true;
}

void remove(string &str, int index, int len) {
    string tmp = "";
    for(int i = 0; i < index; i++) 
        tmp += str[i];
    
    tmp += "E";
    
    for(int i = index+len; i < str.length(); i++) 
        tmp += str[i];
    str = tmp;
}

int find(string &str, string &pat) {
    int n = str.length();
    int m = pat.length();

    if(n < m)
        return -1;

    for(int i = 0; i <= n-m; i++) {
        string tmp = str.substr(i, m);
        if(equals(tmp, pat))
            return i;
    }

    return -1;
}

void solve_problem() {
// give E instead of 0/1
    string str;
    cin >> str;

    vector<string> rules;
    rules.push_back("E+E");
    rules.push_back("E*E");
    rules.push_back("(E)");

    int i = 0;

    while(str.length() != 1 && i++ < 100) {
        bool updated = false;
        for(string it: rules) {
            int pos = find(str, it);
            if(pos != -1) {
                updated = true;
                remove(str, pos, it.length());
            }
        }
        if(!updated) break;
    }

    if(str.length() == 1 && str[0] == 'E') 
        cout << "Valid" << endl;
    else
        cout << "Invalid" << endl;

    cout << str << endl;
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
    cout << setprecision(16);

    int test = 1;   
    // cin >> test;
    while(test--) solve_problem();

    return 0;
} 
