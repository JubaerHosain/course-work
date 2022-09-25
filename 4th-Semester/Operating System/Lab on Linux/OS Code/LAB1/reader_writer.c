#include<semaphore.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>

sem_t lock, rw_lock;
pthread_t writerthreads[1000],readerthreads[1000];
int reader_count = 0;

void *reader(void* param) {
	int cnt = 1;
	sem_wait(&lock);
	reader_count++;
	if(reader_count == 1)
		sem_wait(&rw_lock);
	sem_post(&lock);

	printf("[Reader (%d) is reading]\n", reader_count);
	sleep(1);

	sem_wait(&lock);
	reader_count--;
	if(reader_count == 0)
	    sem_post(&rw_lock);
	printf("[Reader (%d) is leaving]\n", reader_count+1);
	sem_post(&lock);
}

void *writer(void* param) {
	int name = * (int *)param; 
	printf("[Writer (%d) is trying to enter]\n", name);
	sem_wait(&rw_lock);
	printf("[Writer (%d) is writing]\n", name);
	sem_post(&rw_lock);
	printf("[Writer (%d) is leaving]\n", name);
	sleep(1);
}

int main() {
    int rw;
    printf("Enter the number of reader/writer: ");
    scanf("%d", &rw);

    sem_init(&lock, 0, 1);
    sem_init(&rw_lock, 0, 1);

    for(int i = 0; i <  rw; i++) {
		int *tid = (int*)malloc(sizeof(int));
		*tid = i+1;
        
        pthread_create(&writerthreads[i], NULL, writer, (void *)tid);
        pthread_create(&readerthreads[i], NULL, reader, NULL);
    }

    for(int i = 0; i < rw; i++) {
        pthread_join(writerthreads[i], NULL);
        pthread_join(readerthreads[i], NULL);
    }

	return 0;
}


















