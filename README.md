/*

Design and implement an in-memory job scheduler.  

A job consists of some task which takes y milliseconds to execute.
Jobs can be scheduled in 3 ways:

1. Execute at a particular time t                                  ====> t0 
2. Execute after every x hours.                                    ====> t0   ====>  (t0 + x) ====>  (t0 + 2x)  
3. Execute after every x hours post completion of previous job     ====> t0   ====>  (t0 + y + x) ====> (t0 + 2y + 2x)

*/






