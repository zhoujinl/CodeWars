package com.jalon.thread;

import java.util.Arrays;

/**
 * Created by Jalon on 10/04/2018.
 * sleep()睡眠时，释放CPU资源，保持对象锁，仍然占有该锁；
 * wait()睡眠时，释放对象锁。
 */
public class ThreadTest implements Runnable {
    int number = 10;

    public void firstMethod() throws Exception {
        System.out.println("firstMethod: in");

        synchronized (this) {
            number += 100;
            System.out.println("firstMethod: "+ number);
        }
    }

    public void secondMethod() throws Exception {
        synchronized (this) {
            /**
             * (休息2S,阻塞线程)
             * 以验证当前线程对象的机锁被占用时,
             * 是否被可以访问其他同步代码块
             */
            System.out.println("secondMethod: in");

            //Thread.sleep(2000);
            this.wait(2000);
            System.out.println("secondMethod: "+ number);
            number *= 200;

        }
    }

    @Override
        public void run() {
            try {
                firstMethod();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    //main方法中主进程会执行
    public static void main(String[] args) throws Exception {
        ThreadTest threadTest = new ThreadTest();
        Thread thread = new Thread(threadTest);
        thread.start();
        threadTest.secondMethod();


    }
}