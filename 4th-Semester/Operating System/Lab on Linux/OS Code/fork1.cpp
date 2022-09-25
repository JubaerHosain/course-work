#include<bits/stdc++.h>
#include<unistd.h>
using namespace std;

int main(void) {
    cout << "This line won't be executed!" << endl;

    int pid = fork();
    
    if(pid < 0) 
        exit(EXIT_FAILURE);
    else if(pid > 0)
        exit(EXIT_SUCCESS);

    cout << "Hello World" << endl;
}