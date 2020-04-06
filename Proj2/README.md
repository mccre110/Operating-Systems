# Project 2 Breakdown

I have three classes that I am submitting: 
- [Sema](Sema.java)
- [MyThread](MyThread.java)
- [Shared](Shared.java)

The Shared class contains a few static fields for two threads to modify sequentially. 

MyThread contains logic for two threads based on their respective thread names. One thread is 
intended to represent Fred pushing and the other is for Wilma. Semaphore one needsto be locked 
when Freds logic begins to run. When Fred is done Wilma is unlocked and begins to run. Upon 
completion Wilma then unlocks Fred’s semaphore and Fred can run. These semaphores are dependent 
on each other and that is how these threads get synchronized. 

Sema creates two threads and passes them to semaphores.
