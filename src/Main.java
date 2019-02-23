import cn.zhuht.JDK8Test.util.Utils;

import java.security.SecureRandom;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args){
//        System.out.println(Utils.createUUID());

        SecureRandom numberGenerator = new SecureRandom();
        byte[] bytes = new byte[16];
        numberGenerator.nextBytes(bytes);
        for (byte b:bytes){
            System.out.print(b+",");
        }
        System.out.println();
//        System.out.println("0x0f:"+0x0f+"."); // 15   0000 1111
//        System.out.println("0x40:"+0x40+"."); //64    0100 0000
//        System.out.println("0x3f:"+0x3f+"."); //63    0011 1111
//        System.out.println("0x80:"+0x80+"."); //128   1000 0000
        System.out.println(bytes[6]);
        System.out.println(Integer.toString(bytes[6],2));
        System.out.println(bytes[6] & 0x0f);
        System.out.println(bytes[6] | 0x0f);
        System.out.println(Integer.parseInt("-1111",2));

        System.out.println(1024>>5);
        System.out.println(-1024>>5);

        System.out.println(Integer.toString(-2147483648,2));
        System.out.println(-2147483648>>>30);
        System.out.println(-2147483648>>30);
        System.out.println(Integer.toString(-2147483647,2));
        System.out.println(-2147483647>>>30);
        System.out.println(-2147483647>>30);

        System.out.println((byte)0xff>>7);

    }
}
