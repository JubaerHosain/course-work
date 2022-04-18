#include<bits/stdc++.h>
using namespace std;
#define endl    '\n'
typedef long long int ll;
typedef pair<int, int> pii;
typedef vector<vector<int>> vii;

/*****user defined function*****/
const int N = 100;
string table[N][N];
// {child, {parents of it}}
map<string, vector<char>> rules;

string remove_spaces(string &word) {
    string new_word;
    for(char ch: word) {
        if(ch != ' ')
            new_word += ch;
    }
    return new_word;
}

string remove_duplicates(string &word) {
    set<char> unique;
    for(char ch: word)
        unique.insert(ch);
    string new_word = "";
    for(char ch: unique)
        new_word += ch;
    return new_word;
}

vector<string> parser(string &input) {
    string parent;
    int i = 0;
    int n = input.length();
    while(i < n && input[i] != '-') {
        parent += input[i];
        i += 1;
    }
    
    i += 2;
    parent = remove_spaces(parent);
    
    vector<string> words;
    words.push_back(parent);

    string word;
    while(i < n) {
        if(input[i] == '|') {
            word = remove_spaces(word);
            words.push_back(word);
            word = "";
        }
        else {
            word += input[i];
        }
        i += 1;
    }
    word = remove_spaces(word);
    words.push_back(word);
    
    return words;
}

string get_symbols(int i, int j) {
    string symbols;
    for(int x = i; x < j; x++) {
        string s1 = table[i][x];
        string s2 = table[x+1][j];
        if(s1.length() == 0 || s2.length() == 0) continue;
        for(int a = 0; a < s1.length(); a++) {
            for(int b = 0; b < s2.length(); b++) {
                string word;
                word.push_back(s1[a]);
                word.push_back(s2[b]);
                if(!rules.count(word)) continue;
                vector<char> parents = rules[word];
                for(char ch: parents)
                    symbols.push_back(ch);
            }
        }
    } 
    symbols = remove_duplicates(symbols);
    return symbols;
}

void cyk_algorithm(string &input, char start_symbol) {
    int n = input.size();

    // for all one length
    for(int i = 0; i < n; i++) {
        string parents;
        string word;
        word.push_back(input[i]);
        if(rules.count(word)) {
            vector<char> list = rules[word];
            for(char ch: list) 
                parents.push_back(ch);
        }
        table[i][i] = parents;
    }

    // from length 2 to upper
    for(int l = 2; l <= n; l++) {
        for(int i = 0; i <= n-l; i++) {
            int j = i + l - 1;
            table[i][j] = get_symbols(i, j);
        }
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) 
            cout << table[i][j] << " ";
        cout << endl;
    }

    // column 1, n
    string last = table[0][n-1];
    for(char ch: last) {
        if(ch == start_symbol) {
            cout << "String is accepted by this language!" << endl;
            return;
        }
    }
    cout << "String is not accepted by this language!" << endl;
}

/*****main function*****/
int main() {

    char start_symbol;
    int no_of_rule;
    string input;

    cout << "Enter starting symbol: ";
    cin >> start_symbol;

    cout << "Enter number of productin rule: ";
    cin >> no_of_rule;

    cout << "Enter " << no_of_rule << " production rule: " << endl;
    for(int i = 1; i <= no_of_rule; i++) {
        string rule;
        cin >> rule;
        vector<string> words = parser(rule);
        for(int i = 1; i < words.size(); i++)
            rules[words[i]].push_back(words[0][0]);
    }

    // for(auto it: rules) {
    //     cout << it.first << ": ";
    //     for(auto it1: it.second)
    //         cout << it1 << " ";
    //     cout << endl;
    // }

    cout << "Enter input string: ";
    cin >> input;

    cyk_algorithm(input, start_symbol);

    

    return 0;
} 