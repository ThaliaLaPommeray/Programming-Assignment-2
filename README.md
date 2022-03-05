# Programming-Assignment-2

Problem 1: Minotaur’s Birthday Party (50 points): 
The Strategy that is implemented in my program:
  One Assigned Guest(Thread 0) is the one that keeps track and will tell Minotaur when every guest has visited the labyrinth
  If a guest goes through the labyringth and there is a cupcake at the end, that guest should only eat the cupcake if its their first time seeing the cupcake at the end of the labyrinth, after their first time having the cupcake they should no longer eat the cupcake should it be at the end of the labyrinth
  The leader will be the ONLY guest that requests a new cupcake after discovering the last cupcake has been eating and while doing so they also track how many cupcakes have been eaten. Once the number of cupcakes eaten = number of guests, Mr. Minotaur can then be notified that every guest has entered the labyrinth
  
  

Problem 2: Minotaur’s Crystal Vase (50 points):

3) The third strategy would allow the quests to line in a queue. Every guest exiting the room was responsible to notify the guest standing in front of the queue that the showroom is available. Guests were allowed to queue multiple times.

This strategy is 
