import cn.zhuht.jdk8test.util.MoneyUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args){
        //System.out.println(MoneyUtils.digitUppercase(250000));
        Set<String> subjects = new HashSet<>();
        subjects.add("语文");
        subjects.add("数学");
        subjects.add("英语");
        subjects.add("物理");
        subjects.add("化学");
        subjects.add("生物");
        streamTest(subjects);
        System.out.println(subjects);

        List<String> list = new ArrayList<>();
        System.out.println();

    }



    public static void mathTest(){
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

    public static void stringSplit(){
        String str = "1 Affenpinscher 艾芬笃宾犬  2 Afghan Hound 阿富汗猎犬  3 Airedale Terrier 万能梗  4 Akita 秋田犬   5 Alaskan Malamute 阿拉斯加雪橇犬  6 American Eskimo Dog 美国爱斯基摩犬   7 American Staffordshire Terrier 美国史特富郡梗  8 American Water Spaniel 美国水猎犬  9 Anatolian Shepherd 安娜图牧羊犬  10 Australian Cattle Dog 澳洲牧牛犬  11 Australian Shepherd 澳洲牧羊犬  12 Australian Terrier 澳洲梗  13 Basenji 贝吉生犬   14 Basset Hound 巴吉度猎犬  15 Beagle 贝高犬   16 Bearded Collie 古代长须牧羊犬  17 Bedlington Terrier 贝林登梗   18 Belgian Malinois 比利时玛利诺犬  19 Belgian Sheepdog 比利时牧羊犬  20 Belgian Tervuren 比利时坦比连犬  21 Bernese Mountain Dog 伯恩山犬  22 Bichon Frise 卷毛比雄犬   23 Black and Tan Coonhound 黑褐猎浣熊犬  24 Bloodhound 血猎犬   25 Border Collie 边境牧羊犬  26 Border Terrier 边境梗  27 Borzoi 波索尔   28 Boston Terrier 波士顿梗   29 Bouvier des Flandres 法兰德斯畜牧犬  30 Boxer 拳狮犬  31 Briard 伯瑞犬   32 Brittany 不列塔尼猎犬   33 Brussels Griffon 比利时粗毛猎犬  34 Bull Terrier 牛头梗  35 Bulldog 老虎犬   36 Bullmastiff 斗牛马士提夫犬  37 Cairn Terrier 凯安梗  38 Canaan Dog 卡南犬   39 Cavalier King Charles Spaniel 查理士王小猎犬  40 Chesapeake Bay Retriever 乞沙比克猎犬  41 Chihuahua 吉娃娃   42 Chinese Crested 中国冠毛犬  43 Chinese Shar-pei 中国沙皮犬  44 Chow Chow 松狮犬     45 Clumber Spaniel 克伦伯犬  46 Cocker Spaniel 曲卡犬  47 Collie 牧羊犬   48 Curly-Coated Retriever 卷毛寻回犬  49 Dachshund 腊肠犬  50 Dalmatian 斑点犬   51 Dandie Dinmont Terrier 短脚狄文梗  52 Doberman Pinscher 都柏文犬   53 English Cocker Spaniel 英国曲卡犬  54 English Setter 英国塞特犬   55 English Springer Spaniel 英国曲卡犬  56 English Toy Spaniel 英国玩赏曲卡犬  57 Field Spaniel 田野猎犬  58 Finnish Spitz 芬兰猎犬   59 Flat-Coated Retriever 平毛寻回犬  60 Fox Terrier (Smooth) 猎狐梗  61 Fox Terrier (Wire) 刚毛猎狐梗  62 Foxhound (American) 美国猎狐犬  63 Foxhound (English) 英国猎狐犬  64 French Bulldog 法国老虎犬   65 German Shepherd Dog 德国牧羊犬   66 German Shorthaired Pointer 德国短毛指示犬  67 German Wirehaired Pointer 德国钢毛指示犬  68 Giant Schnauzer 大型史纳莎  69 Golden Retriever 黄金猎犬  70 Gordon Setter 哥顿塞特犬  71 Great Dane 大丹犬   72 Great Pyrenees 大白熊犬   73 Greater Swiss Mountain Dog 大瑞士山地犬  74 Greyhound 格雷伊猎犬  75 Harrier 哈利犬  76 Havanese 哈威那   77 Ibizan Hound 依比沙猎犬  78 Irish Setter 爱尔兰塞特犬  79 Irish Terrier 爱尔兰梗   80 Irish Water Spaniel 爱尔兰水猎犬  81 Irish Wolfhound 爱尔兰猎狼犬   82 Italian Greyhound 义大利格雷伊猎犬  83 Jack Russell Terrier 积奇罗素梗  84 Japanese Chin 日本犬  85 Keeshond 荷兰毛狮犬   86 Kerry Blue Terrier 凯利蓝梗  87 Komondor 可蒙犬  88 Kuvasz 哥威斯犬   89 Labrador Retriever 拉布拉多犬  90 Lakeland Terrier 湖畔梗   91 Lhasa Apso 拉萨犬  92 L?wchen 罗秦犬  93 Maltese 玛尔济斯   94 Manchester Terrier 曼彻斯特梗  95 Mastiff 马士提夫犬   96 Miniature Bull Terrier 迷你牛头梗  97 Miniature Pinscher 迷你笃宾犬  98 Miniature Schnauzer 迷你史纳莎  99 Newfoundland 纽芬兰犬  100 Norfolk Terrier 罗福梗   101 Norwegian Elkhound 挪威猎麋犬  102 Norwich Terrier 罗威士梗   103 Old English Sheepdog 古代英国牧羊犬  104 Otterhound 奥达猎犬  105 Papillon 蝴蝶犬  106 Pekingese 北京犬   107 Petit Basset Griffon Vendeen 迷你贝吉格里芬凡丁犬  108 Pharaoh Hound 法老王猎犬  109 Plott Hound 普罗特猎犬   110 Polish Lowland Sheepdog 波兰低地牧羊犬  111 Pointer 指示犬   112 Pomeranian 松鼠犬  113 Poodle 贵妇犬   114 Portuguese Water Dog 葡萄牙水犬  115 Pug 八哥  116 Puli 波利犬   117 Rhodesian Ridgeback 118 Rottweiler 洛威拿  119 Saint Bernard 圣伯纳犬  120 Saluki 东非猎犬  121 Samoyed 萨摩犬  122 Schipperke 舒柏奇犬   123 Scottish Deerhound 苏格兰猎鹿犬  124 Scottish Terrier 苏格兰梗  125 Sealyham Terrier 西里汉梗   126 Shetland Sheepdog 喜乐蒂牧羊犬  127 Shiba Inu 西巴犬  128 Shih Tzu 西施   129 Siberian Husky 西伯利亚雪橇犬  130 Silky Terrier 丝毛梗  131 Skye Terrier 斯开岛梗   132 Soft Coated Wheaten Terrier 爱尔兰软毛梗  133 Spinone Italiano 史毕诺犬   134 Staffordshire Bull Terrier 斯塔福郡斗牛梗  135 Standard Schnauzer 标准史纳莎  136 Sussex Spaniel 塞式猎犬  137 Tibetan Spaniel 西藏猎犬";
        String s1 = " ";
        String s2 = "  ";

        String strs[] = str.split(s2);
        System.out.println(Arrays.toString(strs));
    }

    public static void streamTest(Set<String> subjects){


        List<String> scores = Arrays.asList("语文","英语","生物","化学","物理","数学","政治","历史","地理");
        subjects.removeAll(scores);
        System.out.println(subjects);
    }
}
