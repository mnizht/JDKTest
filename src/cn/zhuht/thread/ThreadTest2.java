package cn.zhuht.thread;

/**
 * @author zhuht
 * @date 2021/9/10 9:48
 */
public class ThreadTest2 {

  static final Thread THREAD = new Thread() {
    @Override
    public void run() {
      int i = 0;
      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(i++);
      }
    }
  };

  public static void main(String[] args) throws InterruptedException {
    System.out.println(Thread.currentThread().getName());
    System.out.println("THREAD.name = " + THREAD.getName());
    THREAD.start();
    Thread.sleep(999999);
  }
}
