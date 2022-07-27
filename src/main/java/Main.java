import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main (String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future> futureList = new ArrayList<>();
        for(int i = 0; i<4; i++)
        {
            Future<Random> newNum = executorService.submit(()->{
                   Random num = new Random();
                   Thread.sleep(3000);
                   return num;
            });
            futureList.add(executorService.submit((Runnable) newNum));
        }

        for (Future f : futureList) {
            f.get();
        }

        System.out.printf("Finished Futures: %s \n",countFinishedFutures(futureList));
        executorService.shutdown();
        System.out.println(futureList.toString());
    }
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