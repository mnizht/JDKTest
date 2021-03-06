package cn.zhuht.jdk8test.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * author zhuhaitao
 * date 2019/2/22 18:28
 *
 * base64 编码方法要求把每三个8bit字节转化为四个6bit字节，然后每个字节前补2个0
 * 由于原本的ascii表示 256 个字符，其中，128-256 为不可见字符，在传输过程中可能会因为协议不同造成错误处理，
 * 所有使用base64 编码成统一可见字符。
 **/
public class Base64Test {
  public static void main(String args[]){
    try {
// 使用基本编码
      String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
      System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
// 解码
      byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
      System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
      base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
      System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < 10; ++i) {
        stringBuilder.append(UUID.randomUUID().toString());
      }
      byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
      String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
      System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
    }catch(UnsupportedEncodingException e){
      System.out.println("Error :" + e.getMessage());
    }
  }
}
