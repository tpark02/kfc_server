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

            // 🔐 락이 완전히 해제됐고, 대기 중인 스레드도 없으면 제거
            if (!lock.isLocked() && !lock.hasQueuedThreads()) {
                lockMap.remove(key, lock); // only remove if value is same as in map
            }
        }
    }
    // Optional: Cleanup unused locks (not strictly needed, but helps memory management in long-running apps)
    public void removeLock(ID key) {
        lockMap.remove(key);
    }
}
