package com.atom.bas.register;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Object>    oneCallable = new Tickets<Object>();
        FutureTask<Object> oneTasl      = new FutureTask<Object>(oneCallable);

        Thread t = new Thread(oneTasl);

        System.out.println(Thread.currentThread().getName());

        t.start();

        System.out.println(oneTasl.get());
    }


}
class Tickets<Object> implements Callable<Object>{

    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " 我是通过实现Callable接口实现的线程");
        return null;
    }
}