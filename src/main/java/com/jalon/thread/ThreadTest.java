package com.jalon.thread;

import java.util.Arrays;

/**
 * Created by Jalon on 10/04/2018.
 * sleep()˯��ʱ���ͷ�CPU��Դ�����ֶ���������Ȼռ�и�����
 * wait()˯��ʱ���ͷŶ�������
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
             * (��Ϣ2S,�����߳�)
             * ����֤��ǰ�̶߳���Ļ�����ռ��ʱ,
             * �Ƿ񱻿��Է�������ͬ�������
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

    //main�����������̻�ִ��
    public static void main(String[] args) throws Exception {
        ThreadTest threadTest = new ThreadTest();
        Thread thread = new Thread(threadTest);
        thread.start();
        threadTest.secondMethod();


    }
}