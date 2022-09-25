/**
* Matrix (N*N) multiplication with multiple threads.
*/
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>

// use wait, signal method

sem_t lock;
int cnt = 0;

void *write(void *arg) {
	while(true) {
		sem_wait(&sema);
		cnt += 1;
		sem_post(&sema);
	}
}



int main() {
  	sem_init(&sema, 0, 1);

  	for ( i = 0; i < N; ++i ) {
    	int *tid = (int*)malloc(sizeof(int));
		*tid = i;
    	pthread_create( &threads[i], NULL, multi, (void *)tid);
  	}
  	for ( i = 0; i < N; ++i ) {
    	pthread_join( threads[i], NULL );
  	}

  	sem_destroy(&sema);

  	return 0;
}





