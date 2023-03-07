#include<semaphore.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>

sem_t rd, wr, rlock, wlock;
pthread_t writerthreads[10000], readerthreads[10000];
int readercount = 0;
int writercount = 0;

int cnt = 0;

void *reader(void* param) {
	int r = *(int*)param;
    sem_wait(&rd);                // permission to attempt read
    sem_wait(&rlock);
    readercount += 1;
    if(readercount == 1)
        sem_wait(&wr);            // lock writers  
    sem_post(&rlock);
    sem_post(&rd);

    // critical section 
    printf("Reader %d reads cnt = %d\n", r, cnt);

    sem_wait(&rlock);
    readercount--;
    if(readercount == 0)
        sem_post(&wr);            // unlock writers
    sem_post(&rlock);
}

void *writer(void* param) {
	int w = *(int*)param;
    sem_wait(&wlock);
    writercount += 1;
    if(writercount == 1)
        sem_wait(&rd);           // block new readers
    sem_post(&wlock);

	sem_wait(&wr);
	cnt += 1;
    printf("Writer %d incresed cnt = %d\n", w, cnt);
	sem_post(&wr);

    sem_wait(&wlock);
    writercount -= 1;
    if(writercount == 0)
        sem_post(&rd);           // unlock readers
    sem_post(&wlock);
}

int main() {
    int n;
    printf("Enter the number of readers/writers: ");
    scanf("%d",&n);
    
    sem_init(&rlock, 0, 1);
    sem_init(&wlock, 0, 1);
    sem_init(&rd, 0, 1);
    sem_init(&wr, 0, 1);

    for(int i = 0; i < n; i++) {
		int *tid = (int*)malloc(sizeof(int));
		*tid = i;
        pthread_create(&writerthreads[i],NULL,writer,(void *)tid);
        pthread_create(&readerthreads[i],NULL,reader,(void *)tid);
        printf("%d\n", i);
    }

    for(int i = 0; i < n; i++) {
        pthread_join(writerthreads[i],NULL);
        pthread_join(readerthreads[i],NULL);
    }

    sem_destroy(&rlock);
    sem_destroy(&wlock);
    sem_destroy(&rd);
    sem_destroy(&wr);
}








