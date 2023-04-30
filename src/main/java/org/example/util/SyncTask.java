package org.example.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SyncTask {

    private ThreadPoolExecutor pool;

    private static final AtomicBoolean initStatus = new AtomicBoolean(false);

    private static final SyncTask INSTANCE = new SyncTask();

    public static SyncTask create(int capacity) {
        if (!initStatus.compareAndSet(false,true)) {
            return INSTANCE;
        }
        int coreSize = capacity / 2;
        assert capacity > 0;
        if (capacity == 1) {
            coreSize = 1;
        }
        INSTANCE.pool = new ThreadPoolExecutor(
                coreSize,
                capacity,
                30,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                (r, executor) -> r.run()
        );
        return INSTANCE;
    }

    public void submit(Runnable r) {
        pool.submit(r);
    }

    public <V> Future<V> submit(Callable<V> c) {
        return pool.submit(c);
    }



}
