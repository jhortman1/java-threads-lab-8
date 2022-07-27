import java.util.List;
import java.util.concurrent.Future;

public class Main {
    public static int countFinishedFutures(List<Future> futures) {
        // your code here
        int total = 0;
        for (Future f : futures)
        {
            if (f.isDone()) total++;
        }
        return total;
    }
}