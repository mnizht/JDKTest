package cn.zhuht.JDK8Test.Stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author zhuhaitao
 * date 2019/2/21 16:44
 **/
//.stream() 创建串行流
//.parallelStream() 创建并行流
public class StreamTest {
  public static void main(String[] args) {
    //使用java7
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
    System.out.println("The number of empty string is: "+getCountEmptyStringUsingJava7(strings));
    System.out.println("The number of string where length is 3: "+getCountLength3UsingJava7(strings));
    System.out.println("delete empty string: "+deleteEmptyUsingJava7(strings));
    System.out.println("delete empty string and merege by comma:"+getMergedStringUsingJava7(strings,","));
    List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
    System.out.println("get the square of the number's list:"+getSquares(numbers));
    List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
    System.out.println("The list:"+integers);
    System.out.println("The max:"+getMax(integers));
    System.out.println("The min:"+getMin(integers));
    System.out.println("The sum:"+getSum(integers));
    System.out.println("The average:"+getAverage(integers));
    System.out.println("Output ten random number:");
    Random random = new Random();
    for(int i=0;i<10;i++){
      System.out.println(random.nextInt());
    }

    //使用java8
    long count = strings.stream().filter(string->string.isEmpty()).count();
    System.out.println("The number of empty string is:"+count);
    count = strings.stream().filter(string->string.length()==3).count();
    System.out.println("The number of string where length is 3:"+count);
    System.out.println("delete empty string:"+strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList()));
    System.out.println("delete empty string and merge by comma:"+strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(",")));
    System.out.println("get square list:"+integers.stream().map(x->x*x).distinct().collect(Collectors.toList()));
    IntSummaryStatistics stas = numbers.stream().mapToInt(x->x).summaryStatistics();
    System.out.println("The max:"+stas.getMax());
    System.out.println("The min:"+stas.getMin());
    System.out.println("The sum:"+stas.getSum());
    System.out.println("The average:"+stas.getAverage());
    System.out.println("The random number:");
    random.ints().limit(10).sorted().forEach(System.out::println);
    //并行处理
    count = strings.parallelStream().filter(string->string.isEmpty()).count();
    System.out.println("The number of empty string is:"+count);
  }

  private static int getCountEmptyStringUsingJava7(List<String> strs) {
    int count = 0;
    for (String str : strs) {
      if (str.isEmpty()) {
        count++;
      }
    }
    return count;
  }

  private static int getCountLength3UsingJava7(List<String> strs) {
    int count = 0;
    for (String str : strs) {
      if (str.length() == 3) {
        count++;
      }
    }
    return count;
  }

  private static List<String> deleteEmptyUsingJava7(List<String> strs) {
    List<String> filterList = new ArrayList<>();
    for (String str : strs) {
      if (!str.isEmpty()) {
        filterList.add(str);
      }
    }
    return filterList;
  }

  private static String getMergedStringUsingJava7(List<String> strs, String separator) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : strs) {
      if (!str.isEmpty()) {
        stringBuilder.append(str);
        stringBuilder.append(separator);
      }
    }
    String mergedString = stringBuilder.toString();
    return mergedString.substring(0, mergedString.length() - 2);
  }

  private static List<Integer> getSquares(List<Integer> numbers) {
    List<Integer> squareList = new ArrayList<>();
    for (Integer num : numbers) {
      Integer square = new Integer(num.intValue() * num.intValue());
      if (!squareList.contains(square)) {
        squareList.add(square);
      }
    }
    return squareList;
  }

  private static int getMax(List<Integer> numbers) {
    int max = numbers.get(0);
    for (int i = 1; i < numbers.size(); i++) {
      int num = numbers.get(i).intValue();
      if (num > max) {
        max = num;
      }
    }
    return max;
  }

  private static int getMin(List<Integer> numbers) {
    int min = numbers.get(0);
    for (int i = 1; i < numbers.size(); i++) {
      int num = numbers.get(i).intValue();
      if (num < min) {
        min = num;
      }
    }
    return min;
  }

  private static int getSum(List<Integer> numbers) {
    int sum = numbers.get(0);
    for (int i = 1; i < numbers.size(); i++) {
      sum += numbers.get(i).intValue();
    }
    return sum;
  }

  private static double getAverage(List<Integer> numbers) {
    return getSum(numbers) / numbers.size();
  }
}
