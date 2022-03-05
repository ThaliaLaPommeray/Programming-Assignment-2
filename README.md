# Programming-Assignment-2

Problem 1: Minotaur’s Birthday Party (50 points): 
The Strategy that is implemented in my program:
  One Assigned Guest(Thread 0) is the one that keeps track and will tell Minotaur when every guest has visited the labyrinth
  If a guest goes through the labyringth and there is a cupcake at the end, that guest should only eat the cupcake if its their first time seeing the cupcake at the end of the labyrinth, after their first time having the cupcake they should no longer eat the cupcake should it be at the end of the labyrinth
  The leader will be the ONLY guest that requests a new cupcake after discovering the last cupcake has been eating and while doing so they also track how many cupcakes have been eaten. Once the number of cupcakes eaten = number of guests, Mr. Minotaur can then be notified that every guest has entered the labyrinth
  
  For this implementation see pa2.java
  The program will ask how many guests are attendance, input num of guests here!
  to compile: run command javac pa2.java java pa2
  The program will print when all guests have entered the labyrinth and output the amount of labyrinth visits that occurs (this should be less than n^2)
  

Problem 2: Minotaur’s Crystal Vase (50 points):

3) The third strategy would allow the quests to line in a queue. Every guest exiting the room was responsible to notify the guest standing in front of the queue that the showroom is available. Guests were allowed to queue multiple times.

The guests should choose option 3 because it will allow each guest to view the showroom unlike option 1
Advantages include guaranteed fairness, minimal contention, and starvation freedom
A disadvantage of this choice would be if a guest/thread were to never leave/unlock, the queue would stall

This strategy is implemented using spinlock, as one thread acquires a lock the other threads or guests wait (or in this case spin in a lock) until the lock is free or unlocked, then the next guest/thread in line can acquire it and so on

This strategy is implemented in prob2.java
When running, this program will ask how many guests and this will be where you input n or the amount of guest in attendance!
to compile: run command javac prob2.java java prob2

  The program will print when all guests have entered the showroom and output the amount of showroom visits that occurs
