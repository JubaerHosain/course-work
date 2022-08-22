#include<bits/stdc++.h>
using namespace std;

vector<char> et(128);

string encrypt(string &input) {
    string encrypted;
    for(char ch: input) 
        encrypted += et[ch];
    return encrypted;
}

string decrypt(string &encrypted) {
    string decrypted;
    for(char ch: encrypted) 
        decrypted += et[ch];
    return decrypted;
}

int main(void) {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    for(int i = 0; i < 128; i++)
        et[i] = (char)(128-i-1);

    string input;
    getline(cin, input);

    cout << "Input text: " << input << endl;

    string encrypted = encrypt(input);
    cout << "Encrypted text: " << encrypted << endl;

    string decrypted = decrypt(encrypted);
    cout << "Decrypted text: " << decrypted << endl;

    return 0;
}