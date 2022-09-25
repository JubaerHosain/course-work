#include <stdio.h>
#include <pthread.h>
        
/*thread function definition*/
void* threadFunction(void* args)
{
    char *message;
    message = (char *) args;
    while(1)
    {
        printf("I am threadFunction %s.\n", message);
        sleep(rand()%2);
    }
}
int main()
{
    /*creating thread id*/
    pthread_t id[2];
    int ret;
    
    /*creating thread*/
    pthread_create(&id[1],NULL,&threadFunction,"1");
    pthread_create(&id[0],NULL,&threadFunction,"22");
    
    while(1)
    {
        printf("I am main function.\n");    
        sleep(rand()%2);  
    }
    
    return 0;
}
