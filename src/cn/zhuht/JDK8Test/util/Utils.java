package cn.zhuht.JDK8Test.util;

import java.util.*;

/**
 * author zhuhaitao
 * date 2019/2/22 15:14
 **/
public class Utils {
  public static void main(String[] args) {

    String id = "30e9b4dc34dd11e9ac8e12f0053031f8";
    List<String> ids = Arrays.asList("30e9b4dc34dd11e9ac8e12f0053031f8", "650b8c0534f811e99f5b12f0053031f8",
      "8400ae5b34db11e9ac8e12f0053031f8", "a3867456357e11e9849c505bc2bd8bdf");
//    System.out.println(Utils.countChar(id));
//    System.out.println(Utils.countChar(ids));

    testCreateUUID();
  }

  /**
   * 统计字符串中各个字符数量
   */
  public static Map<Character, Integer> countChar(String str) {
    Map<Character, Integer> map = new HashMap<>();
    count(map, str);
    return map;
  }

  public static Map<Character, Integer> countChar(List<String> strs) {
    Map<Character, Integer> map = new HashMap<>();
    for (String str : strs) {
      count(map, str);
    }
    return map;
  }

  private static void count(Map<Character, Integer> map, String str) {
    char[] chars = str.toCharArray();
    for (char c : chars) {
      map.put(c, (map.get(c) == null ? 0 : map.get(c)) + 1);
    }
  }

  //生成UUId
  public static String createUUID() {
    return UUID.randomUUID().toString();
  }

  public static void testCreateUUID() {
    int[] randoms = new int[16];
    Random rd = new Random();
    for (int i = 0; i < randoms.length; i++) {
      randoms[i] = rd.nextInt();
    }
    printInt(randoms);
    //testYunsuan(randoms);
    System.out.println("===============================");
    byte[] bytes1 = new byte[16];
    byte[] bytes2 = new byte[16];
    nextBytes(randoms,bytes1);
    //nextBytes2(randoms,bytes2);
    printByte(bytes1);
    //printByte(bytes2);
    andOrYunsuan(bytes1);
    mergeLong(bytes1);

  }
  public static void nextBytes(int[] ints,byte[] bytes) {
    for (int i = 0, len = bytes.length; i < len; )
      for (int rnd = ints[i] ,
           n = Math.min(len - i, Integer.SIZE/Byte.SIZE);
           n-- > 0; rnd >>= Byte.SIZE)
        bytes[i++] = (byte)rnd;
  }
  public static void nextBytes2(int[] ints,byte[] bytes) {
    for (int i = 0, len = bytes.length; i < len; )
      for (int rnd = ints[i] ,
           n = Math.min(len - i, Integer.SIZE/Byte.SIZE);
           n-- > 0; rnd /= 256)//此处会有小数保留问题，右移运算相当于除完直接去掉小数位，不做四舍五入
        bytes[i++] = (byte)rnd;

  }

  public static void printInt(int[] ints){
    for (int i:ints){
      System.out.print(i+",");
    }
    System.out.println();
  }
  public static void printByte(byte[] bytes){
    for (byte b:bytes){
      System.out.print(b+",");
    }
    System.out.println();
  }

  public static void testYunsuan(int[] ints){
    for (int i:ints){
      System.out.print(i>>8);
      System.out.print("<-->");
      System.out.print(i/256);
      System.out.print(", ");
    }
  }

  public static void andOrYunsuan(byte[] randomBytes){
    randomBytes[6]  &= 0x0f;  /* clear version        */
    randomBytes[6]  |= 0x40;  /* set to version 4     */
    randomBytes[8]  &= 0x3f;  /* clear variant        */
    randomBytes[8]  |= 0x80;  /* set to IETF variant  */
  }

  public static void mergeLong(byte[] data){
    long msb = 0;
    long lsb = 0;
    assert data.length == 16 : "data must be 16 bytes in length";
    for (int i=0; i<8; i++)
      msb = (msb << 8) | (data[i] & 0xff);
    for (int i=8; i<16; i++)
      lsb = (lsb << 8) | (data[i] & 0xff);
    System.out.println("msb="+msb);
    System.out.println("lsb="+lsb);
  }
}
