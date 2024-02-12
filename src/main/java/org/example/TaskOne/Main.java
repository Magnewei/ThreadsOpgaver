package org.example.TaskOne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {

    public static void main( String[] args ) {
        //ExecutorService workingJack = Executors.newSingleThreadExecutor();
        System.out.println( "Main starts" );
        Thread t = new Thread(){

            @Override
            public void run() {
                for (char c = 'A'; c <= 'Z'; ++c) {
                    System.out.print(c);
                    System.out.print(c);
                    System.out.print(c);
                    System.out.print("\n");
                }
            }
        };
        t.start();
        System.out.println( "Main is done" );
    }

}


