package nio;

import okio.BufferedSource;
import okio.Okio;
import okio.Source;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio
 *
 * @author rj-liang
 * @date 2021/3/1 15:04
 */
public class IOStreamTest {
    public static void main(String[] args) {
//        testFileInputStream();
//        testFileReader();
//        testNIO();
        testOkio();
    }

    public static void testFileInputStream() {
        FileInputStream fis = null;
        try {
            File file = new File("E:\\test.txt");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len; //记录每次读取的字节个数
//            System.out.println(fis.read(buffer));
            while ((len = fis.read(buffer)) != -1) {
                //转成String型，否则输出ASCII码
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testFileOutStream() {


    }

    public static void testFileReader() {
        //定义输入流
        Reader fr = null;
        try {
            //1、创建文件对象
            File file = new File("E:\\test.txt");
            //2、创建输入流对象
            fr = new FileReader(file);

            //循环读取，读取到末尾返回-1
            int len;//记录每次读取的字节个数
            while ((len = fr.read()) != -1) {
                System.out.print((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testBuffer() {
        //定义缓冲流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //开始时间
            long start = System.currentTimeMillis();
            //创建缓冲流对象，注意参数传的FileXXX，而不文件目录
            bis = new BufferedInputStream(new FileInputStream("D:\\IO\\1.mp4"));
            bos = new BufferedOutputStream(new FileOutputStream("D:\\IO\\3.mp4"));
            //读写操作
            int len;
            byte[] buffer = new byte[1024];
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            //结束时间
            long end = System.currentTimeMillis();
            System.out.println("完成,共耗时："+(end-start)+"ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bos.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testNIO() {
//        File file = new File("E:\\test.txt");
        File file = new File("E:\\UpdateCfg.ini");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            FileChannel channel = fin.getChannel();

            int capacity = 1024;// 字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity()
                    + "位置是：" + bf.position());
            int length = -1;

            while ((length = channel.read(bf)) != -1) {

                /*
                 * 注意，读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
                 */
                bf.clear();
                byte[] bytes = bf.array();
                String str = new String(bytes, 0, length);
                System.out.print(str);
                System.out.println();

//                System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity()
//                        + "位置是：" + bf.position());

            }

            channel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void testOkio() {
//        try (Source fileSource = Okio.source(new File("E:\\test.txt"));
//             BufferedSource bufferedSource = Okio.buffer(fileSource)) {
//            while (true) {
//                String line = bufferedSource.readUtf8Line();
//                if (line == null) break;
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try (Source fileSource = Okio.source(new File("E:\\test.txt"));
             BufferedSource bufferedSource = Okio.buffer(fileSource)) {
             String line = bufferedSource.readUtf8();
            System.out.println(line);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
