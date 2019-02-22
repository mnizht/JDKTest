package cn.zhuht.JDK8Test.MathReference;

/**
 * author zhuhaitao
 * date 2019/2/21 11:41
 **/
public interface Supplier<T> {
  T get();
}
class Car{
  String name;

  public Car() {
  }

  public Car(String name) {
    this.name = name;
  }

  public static Car create(Supplier<Car> supplier){
    return supplier.get();
  }
  public static void collide(final Car car){
    System.out.println("Collide "+car.toString());
  }
  public void follow(final Car another){
    System.out.println("Following the "+another.toString());
  }
  public void repair(){
    System.out.println("Repair "+this.toString());
  }
}
