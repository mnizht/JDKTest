package cn.zhuht.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuht
 * @date 2022/3/14 22:55
 */
public class FileTest {
    public static void main(String[] args) {
        String path = "D:\\PersonalCloud";
//        Map<String, List<File>> file = getFile(path);
//
//        for (Map.Entry<String, List<File>> entry : file.entrySet()) {
//            System.out.println("文件夹：" + entry.getKey());
//            entry.getValue().forEach(f -> System.out.println(f.getName()));
//        }
//        List<File> list = new ArrayList<>();
//        lsAll(new File(path), list);
//        list.forEach(System.out::println);

        newFile();
    }

    public static void newFile(){
        String fileName = "D:\\temp\\file\\test.txt";
        File file = new File(fileName);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()){
            parentFile.mkdirs();
        }

        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("两个黄鹂鸣翠柳".getBytes(StandardCharsets.UTF_8));
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lsAll(File dir, List<File> list) {

        if (dir.exists()) {
            if (dir.isFile()) {
                list.add(dir);
            } else if (dir.isDirectory()) {
                File[] listFiles = dir.listFiles();
                if (null != listFiles) {
                    for (File file : listFiles) {
                        lsAll(file, list);
                    }
                }
            }
        }
    }

    public static Map<String, List<File>> getFile(String basePath) {
        Map<String, List<File>> dirs = new HashMap<>();
        File dir = new File(basePath);
        if (dir.exists()) {
            lsFile(dirs, dir, "");
        }
        return dirs;
    }

    private static void lsFile(Map<String, List<File>> dirs, File file, String proKey) {
        String key = proKey + file.getName() + "/";
        File[] files = file.listFiles();
        if (null != files && files.length > 0) {
            List<File> pic = new ArrayList<>();
            for (File childFile : files) {
                if (childFile.isDirectory()) {
                    lsFile(dirs, childFile, key);
                } else if (childFile.isFile()) {
                    pic.add(childFile);
                }
            }
            if (!pic.isEmpty()) {
                dirs.put(key, pic);
            }
        }
    }
}
