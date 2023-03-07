#include <stdio.h>
#include <pthread.h>

void *print_message_function(void *ptr);

main()
{
     pthread_t thread1, thread2;
     char *message1 = "111111";
     char *message2 = "22";
     int  iret1, iret2;

    /* Create independent threads each of which will execute function */

     iret1 = pthread_create( &thread1, NULL, print_message_function, (void*) message1);
     iret2 = pthread_create( &thread2, NULL, print_message_function, (void*) message2);

     /* Wait till threads are complete before main continues. Unless we  */
     /* wait we run the risk of executing an exit which will terminate   */
     /* the process and all threads before the threads have completed.   */

     pthread_join(thread1, NULL);
     pthread_join(thread2, NULL); 


   while(1) {
      printf("I am main\n");
      sleep(rand()%2);
   }

     printf("Thread 1 returns: %d\n",iret1);
     printf("Thread 2 returns: %d\n",iret2);
   //   exit(0);

   return 0;
}

void *print_message_function( void *ptr )
{
   while(1) {
      char *message;
      message = (char *) ptr;
      printf("%s \n", message);

      sleep(rand()%2);
   }
}