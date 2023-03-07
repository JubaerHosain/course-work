#include<bits/stdc++.h>
using namespace std;
 
/*****User defined function*****/
const int N = 256;

vector<int> key_scheduling(vector<int> key) {
    vector<int> S(256), T(256);
    
    // initialize S and T
    for(int i = 0; i < 256; i++) {
        S[i] = i;
        T[i] = key[i%key.size()];
    }

    for(int i = 0, j = 0; i < 256; i++) {
        j = (j+S[i]+T[i])%256;
        swap(S[i], S[j]);
    }

    return S;
}

string rc4(string input_text, vector<int> S) {
    string converted_text;
    int i = 0, j = 0, k;

    for(char ch: input_text) {
        i = (i + 1) % 256;
        j = (j + S[i]) % 256;

        swap(S[i], S[j]);

        // key for r'th byte
        k = (S[i]+S[j])%256;

        // cast char as an int then xor with k
        int converted = (int)ch ^ k;

        // cast int as char then append to string
        converted_text += (char)converted;
    }

    return converted_text;
}
 
/*****main function*****/
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // #ifndef ONLINE_JUDGE
    // freopen("input.txt", "r", stdin);
    // #endif 

    string plain_text;
    cin >> plain_text;
 
    // key
    vector<int> key = {1, 2, 3, 4, 5};

    // returns state vector
    vector<int> S = key_scheduling(key);

    // same algorithm is used to encryption and decryption
    string cipher_text = rc4(plain_text, S);
    string original_text = rc4(cipher_text, S);

    cout << cipher_text << endl;
    cout << original_text << endl;

    return 0;
} 
