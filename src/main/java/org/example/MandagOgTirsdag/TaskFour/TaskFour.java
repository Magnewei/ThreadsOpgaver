package org.example.MandagOgTirsdag.TaskFour;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {

    public static void main(String[] args) {
        //ExecutorService workingJack = Executors.newSingleThreadExecutor();
        System.out.println("Main starts");
        ExecutorService workingJack = Executors.newFixedThreadPool(3000);
        for(int i = 0; i < 100000; i++){
            workingJack.submit(new MyTask(i));
        }
        workingJack.shutdown();
        System.out.println("Main is done");
    }


}

class MyTask implements Runnable {
    int n;

    public MyTask(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Task: " + n);
    }

}



