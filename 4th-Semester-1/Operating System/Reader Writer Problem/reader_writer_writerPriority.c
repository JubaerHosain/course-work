#include<semaphore.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>

sem_t rd, wr, rlock, wlock;
pthread_t tid;
pthread_t writerthreads[1000000], readerthreads[1000000];
int readercount = 0;
int writercount = 0;

void *reader(void* param) {
    sem_wait(&rd);                // permission to attempt read
    sem_wait(&rlock);
    readercount += 1;
    if(readercount == 1)
        sem_wait(&wr);            // lock writers  
    sem_post(&rlock);
    sem_post(&rd);

    // critical section 
    printf("Reader %d is inside\n", readercount);
    sleep(rand()%3);

    sem_wait(&rlock);
    readercount--;
    if(readercount == 0)
        sem_post(&wr);           // unlock writers
    sem_post(&rlock);

    printf("Reader %d is leaving\n", readercount + 1);
}

void *writer(void* param) {
    printf("Writer %d is trying to enter\n", writercount);

    sem_wait(&wlock);
    writercount += 1;
    if(writercount == 1)
        sem_wait(&rd);         // block readers
    sem_post(&wlock);

    printf("Writer %d has entered\n", writercount);
    sleep(rand()%3);

    sem_wait(&wlock);
    writercount -= 1;
    if(writercount == 0)
        sem_post(&rd);          // unlock readers
    sem_post(&wlock);

    printf("Writer %d is leaving\n", writercount + 1);
}

int main() {
    int n;
    printf("Enter the number of readers: ");
    scanf("%d",&n);
    
    sem_init(&rlock, 0, 1);
    sem_init(&wlock, 0, 1);
    sem_init(&rd, 0, 1);
    sem_init(&wr, 0, 1);

    for(int i = 0; i < n; i++) {
        pthread_create(&writerthreads[i],NULL,writer,NULL);
        pthread_create(&readerthreads[i],NULL,reader,NULL);
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