package cn.zhuht.thread;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haitao zhu
 * @date 2020/6/23 15:56
 */
public class ThreadTest {
  public static void main(String[] args) throws IOException {
    int corePoolSize = 2; //核心线程池大小
    int maximumPoolSize = 4; // 最大线程池大小
    long keepAliveTime = 10; // 线程最大空闲时间
    TimeUnit unit = TimeUnit.SECONDS; // 时间单位
    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2); // 线程等待队列
    ThreadFactory threadFactory = new NameThreadFactory(); //线程创建工厂
    RejectedExecutionHandler handler = new MyIgnorePolicy(); // 拒绝策略

    ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
      maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    executor.prestartAllCoreThreads(); //预启动所有核心线程
//    for (int i = 1; i <= 10; i++) {
//      MyTask task = new MyTask(String.valueOf(i));
//      executor.execute(task);
//    }
    AtomicInteger integer = new AtomicInteger(1);
    for (int i = 0; i < 10; i++) {
      executorService.submit(() -> System.out.println(String.format("Thread %d is running",integer.getAndIncrement())));
    }

//    System.in.read(); //阻塞主线程

  }

  static class NameThreadFactory implements ThreadFactory {
    // 一个int可能原子更新的值
    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
      Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
      System.out.println(t.getName() + "has been created");
      return t;
    }
  }

  public static class MyIgnorePolicy implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
      System.err.println(r.toString() + "rejected");
    }
  }

  static class MyTask implements Runnable {
    private String name;

    public MyTask(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      System.out.println(this.toString() + "is running!");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return "MyTask{" +
        "name='" + name + '\'' +
        '}';
    }
  }
}
