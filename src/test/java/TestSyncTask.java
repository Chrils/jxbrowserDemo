import org.example.util.LogSleeper;
import org.example.util.SyncTask;

import java.io.Closeable;
import java.util.concurrent.Future;

public class TestSyncTask {

    public static void main(String[] args) {
        SyncTask syncTask = SyncTask.create(2);
        for (int i = 0; i < 5; i++) {
            syncTask.submit(LogSleeper::randomSleep);
        }
    }
}
