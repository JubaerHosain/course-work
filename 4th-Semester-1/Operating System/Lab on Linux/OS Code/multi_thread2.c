#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

// Let us create a global variable to change it in threads
int g = 0;

// The function to be executed by all threads
void *myThreadFun(void *vargp)
{
	while(1) {
        printf("Thread %d\n", (int)vargp);
        sleep(1);
    } 
}

int main()
{
	int i;
	pthread_t tid[5];

	// Let us create three threads
	for (i = 0; i < 3; i++)
		pthread_create(&tid[i], NULL, myThreadFun, (void *)i);

	pthread_exit(NULL);
	return 0;
}
