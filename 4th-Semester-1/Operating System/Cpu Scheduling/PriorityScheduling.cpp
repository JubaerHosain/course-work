#include<bits/stdc++.h>
using namespace std;

struct Process {
	int pid;        // Process ID
	int bt;         // CPU Burst time required
	int priority;   // Priority of this process
};

// Function to sort the Process acc. to priority
bool comparison(Process a, Process b)
{
	return (a.priority > b.priority);
}

void find_waiting_time(Process proc[], int n, int wt[]) {
	// waiting time for first process is 0
	wt[0] = 0;

	// calculating waiting time
	for (int i = 1; i < n ; i++ )
		wt[i] = proc[i-1].bt + wt[i-1] ;
}

// Function to calculate turn around time
void find_turn_around_time(Process proc[], int n, int wt[], int tat[]) {
	// calculating turnaround time by adding bt[i] + wt[i]
	for (int i = 0; i < n ; i++)
		tat[i] = proc[i].bt + wt[i];
}

void find_times(Process proc[], int n)
{
	int wt[n], tat[n], total_wt = 0, total_tat = 0;

	find_waiting_time(proc, n, wt);

	find_turn_around_time(proc, n, wt, tat);

	//Display processes along with all details
	cout << "\nProcesses "<< " Burst time " << " Waiting time " << " Turn around time\n";

	// Calculate total waiting time and total turn around time
	for (int i=0; i<n; i++) {
		total_wt = total_wt + wt[i];
		total_tat = total_tat + tat[i];
		cout << " " << proc[i].pid << "\t\t" << proc[i].bt << "\t " << wt[i] << "\t\t " << tat[i] <<endl;
	}

	cout << "\nAverage waiting time = " << (float)total_wt / (float)n;
	cout << "\nAverage turn around time = " << (float)total_tat / (float)n;
}

void priority_scheduling(Process proc[], int n) {
	// Sort processes by priority
	sort(proc, proc + n, comparison);

	cout<< "Order in which processes gets executed \n";
	for (int i = 0 ; i < n; i++)
		cout << proc[i].pid <<" " ;

	find_times(proc, n);
}

int main() {
	Process processes[] = {{1, 10, 2}, {2, 5, 0}, {3, 8, 1}};

	int n = sizeof processes / sizeof processes[0];
	priority_scheduling(processes, n);

	return 0;
}
