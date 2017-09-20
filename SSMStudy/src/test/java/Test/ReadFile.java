package Test;

import java.io.*;

/**
 * Created by Administrator on 2017/9/14.
 */
public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("d:\\三生三世.mp3");
            if (!file.exists()){
                file.createNewFile();
            }
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            byte b [] = new byte[1024];
            int n=0;
            System.out.println("三生三世.mp3的内容如下：");
            while ((n=dis.read(b, 0, b.length))!=-1) {
                String string = new String(b, 0, n);
                System.out.println(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
