# Optimus prime (sieve of Eratosthenes)
## Exercise description
For a long time, prime numbers were thought to have extremely limited application outside of pure mathematics. This changed in the 1970s when the concepts of public-key cryptography were invented, in which prime numbers formed the basis of the first algorithms such as the RSA cryptosystem algorithm (it is used eg. in the HTTPS protocol to secure online banking/facebook activity). 

Since 1951, all the largest known primes have been found by computers. The search for ever larger primes has generated interest outside mathematical circles.

The sieve of Eratosthenes is a simple, ancient algorithm for finding all prime numbers up to any given limit.

Now, the task is to count the number of prime numbers less than a non-negative number (n) by using the sieve.

###Optimization ideas:

* You have infinite amount of memory, but a slow CPU: you can use as many and as large data structures as you want.
* You have infinite amount of CPU but limited memory: store as few data as you can in variables while the program runs.
* You must create at least a "basic" solution and/or you can submit one or both of the two optimized functions as well. The optimized functions should return the same as the general solution would, there is no change in the specification, only the inside algorithm differs.

solution with map much slower
