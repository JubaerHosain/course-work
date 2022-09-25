#include<bits/stdc++.h>
#include<unistd.h>
using namespace std;

int main(void) {
    vector<int> a = {3, 2, 1, 2, 3};
    cout << "Initial arrray: ";
    for(int i = 0; i < a.size(); i++)
        cout << a[i] << " ";
    cout << endl;
    
    int pid = fork();

    if(pid != 0) {
        vector<int> freq(10);
        for(int i = 0; i < a.size(); i++)
            freq[a[i]] += 1;
        cout << "I'm parent" << endl;
        cout << "Value   Frequency" << endl;
        for(int i = 0; i < 10; i++) {
            if(freq[i] > 0)
                cout << i << " -> " << freq[i] << endl;
        }
    } else {
        cout << "I'm first child" << endl;
        int sum = 0; 
        for(int i = 0; i < a.size(); i++) {
            if(a[i]%2 == 0)
                sum += a[i];
        }
        cout << "Sum of even numbers is: " << sum << endl;

        int pid1 = fork();
        if(pid1 != 0) {
            cout << "I'm second child" << endl;
            int cnt = 0;
            for(int i = 0; i < a.size(); i++) {
                if(a[i]%2 == 0)
                    cnt += 1;
            }
            cout << "Count of even numbers: " << cnt << endl;
        } else {
            cout << "I'm third child" << endl;
            sort(a.begin(), a.end());
            cout << "Sorted array: ";
            for(int i = 0; i < a.size(); i++) 
                cout << a[i] << " ";
            cout << endl;
        }
    }
}