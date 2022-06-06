package thread.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {
    private List<String> dataList = new ArrayList<>();
    private synchronized void recordData(String data) {
        dataList.add(data);
    }

    private void sendData() {
        synchronized (dataList) {
            System.out.printf("\n");
            for (String data : dataList) {
                System.out.printf(data + "\n");
            }
        }
    }

    public static void main(String[] args) {
        final TestThread testThread = new TestThread();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 4; i++) {
            System.out.printf(i + " ");
            executorService.execute(() -> testThread.recordData("data"));
        }
        System.out.printf("\nsendData");
        executorService.execute(() -> testThread.sendData());
    }
}
