/*

Design and implement an in-memory job scheduler

job --> particular time t   [5:30 PM]  [Adhoc]
job --> after every x hours.                                      ====> t0,  (t0 + x)     --> next instance
job --> after every x hours post completion of previous job.     ====> t0,  (t0 + 1) + x --> next instance, (t0 + 1 + x + 3) + x --> next instance

*/






