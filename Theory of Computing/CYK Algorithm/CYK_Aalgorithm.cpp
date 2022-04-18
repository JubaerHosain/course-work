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
map<string, vector<string>> rules;

string remove_spaces(string &word) {
    string new_word;
    for(char ch: word) {
        if(ch != ' ')
            new_word += ch;
    }
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

void cyk_algorithm() {
    char start;
    int no_of_rule;
    string input;

    cout << "Enter starting symbol: ";
    cin >> start;

    cout << "Enter number of productin rule: ";
    cin >> no_of_rule;

    cout << "Enter " << no_of_rule << " production rule: " << endl;
    for(int i = 1; i <= no_of_rule; i++) {
        string rule;
        cin >> rule;
        vector<string> words = parser(rule);
        for(int i = 1; i < words.size(); i++)
            rules[words[i]].push_back(words[0]);
    }

    cout << "Enter input string: ";
    cin >> input;
}

/*****main function*****/
int main() {

    cyk_algorithm();

    return 0;
} 