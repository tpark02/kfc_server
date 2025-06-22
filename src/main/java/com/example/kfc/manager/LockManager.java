package com.example.kfc.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class LockManager<ID> {

    private final ConcurrentHashMap<ID, ReentrantLock> lockMap = new ConcurrentHashMap<>();

    public ReentrantLock getLock(ID key) {
        return lockMap.computeIfAbsent(key, k -> new ReentrantLock());
    }

    public void lock(ID key) {
        getLock(key).lock();
    }

    public void unlock(ID key) {
        ReentrantLock lock = lockMap.get(key);
        if (lock != null && lock.isHeldByCurrentThread()) {
            lock.unlock();

            if (!lock.isLocked() && !lock.hasQueuedThreads()) {
                lockMap.remove(key, lock); // only remove if value is same as in map
            }
        }
    }
    public void removeLock(ID key) {
        lockMap.remove(key);
    }
}
