#include<bits/stdc++.h>
using namespace std;
typedef unsigned char uchar;

//  (Vigenère Cipher)

string encrypt(string &key, string &input) {
    string encrypted;
    int m = key.length(), n = input.length();
    for(int i = 0; i < n; i++) {
        uchar pi = input[i];
        uchar ki = key[i%m];
        char cipher = (pi + ki) % 128;
        encrypted += cipher;
    }
    return encrypted;
}

string decrypt(string &key, string &encrypted) {
    string decrypted;
    int m = key.length(), n = encrypted.length();
    for(int i = 0; i < n; i++) {
        uchar cipher = encrypted[i];
        uchar ki = key[i%m];
        char pi = (cipher - ki + 128) % 128;
        decrypted += pi;
    }
    return decrypted;
}

int main(void) {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    string key, input;
    getline(cin, key);
    getline(cin, input);

    cout << "Key: " << key << endl;
    cout << "Input text: " << input << endl;

    string encrypted = encrypt(key, input);
    cout << "Encrypted text: " << encrypted << endl;

    string decrypted = decrypt(key, encrypted);
    cout << "Decrypted text: " << decrypted << endl;

    return 0;
}