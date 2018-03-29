# RandomQueue
## CSIS 2420 Assignment 3.

#### To run:
* There are a few tricky bits. You can probably do this another way, so if someone knows how please let me know.
* Follow the directions from one of the following sites depending on OS:
  * https://algs4.cs.princeton.edu/mac/
  * https://algs4.cs.princeton.edu/linux/
  * https://algs4.cs.princeton.edu/windows/
  * This is a popular course, if the links don't work you should be able to find it somewhere
* Now compile them as per the directions on the previous site
  * Example: `javac-algs4 [filename]`
* Queue this up while that compiles https://www.youtube.com/watch?v=Vd6wi8nDJhU
* Now run them with the same algs4 wrapper 
  * Example `echo [string] | java-algs4 Subset 5`
* For an optimal experience listen to the following upon the first compilation:
  * https://www.youtube.com/watch?v=Vd6wi8nDJhU



#### About the progam:
* First, don't copy this or you're robbing yourself of learining how to do it.
* Down to business.
* This implements a queue with an array that doubles in size when it reaches capacity and halves in size when it reaches one quarter capacity
* The iterator returns a random element from the set. It will iterate through the array returning each element once.
* Two iterators of the same instance will be unique.
* The iterator returns elements in constant time. 
