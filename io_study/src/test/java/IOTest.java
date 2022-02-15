import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

//io学习
public class IOTest {


    //测试文件输出流：FileOutputStream
    @Test
    public void TEST1() throws Exception {

        //在项目的跟目录下创建文件
        File file = new File("Test1.txt");
        //append为boolean类型参数，true表示继续向文件中添加，如果为false则会覆盖现有文件
        FileOutputStream fos = new FileOutputStream(file,false);
        //通过write方法进行写入,支持写入底层编码数字和字符数组`
        fos.write(97);
        fos.write(98);
        fos.write(99);
        //换行,windows是\r\n,linux是\n
        fos.write("\r\n".getBytes());
        //通过字符数组方式写入
        byte[] a = {'a','s','c','r'};
        fos.write(a);
        //把字符串转为字符存储到字符数组中
        byte[] b = "王者荣耀".getBytes(StandardCharsets.UTF_8);
        fos.write(b);
        //刷新流
        fos.flush();
        //关闭流
        fos.close();
    }

    //测试文件字节输入流：FileInputStream
    @Test
    public void TEST2() throws Exception {
        //创建fis对象
        FileInputStream fis = new FileInputStream("Test1.txt");
        //按照字节读取
     /*   int b = 0;
        while ((b=fis.read()) != -1){
            System.out.print((char) b);
        }*/
        //使用数组读取
        int len;
        byte[] a = new byte[3];
        while ((len=(fis.read(a))) != -1){
            System.out.print(new String(a,0,len));
        }
        fis.close();
    }

    //图片复制
    @Test
    public void TEST3() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\风月\\Desktop\\1.jpeg");
        FileOutputStream fos = new FileOutputStream("2.jpeg");
        int len;
        byte[] temp = new byte[8];
        while ((len = (fis.read(temp))) != -1){
            fos.write(temp,0,len);
        }
        fos.close();
        fis.close();
    }
}
