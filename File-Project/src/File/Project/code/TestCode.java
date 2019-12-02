package File.Project.code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TestCode {
    public static void main(String[] args) {
//        System.getProperties().list(System.out);
//内存流
//        此处转化都是在内存中进行
        String msg = "hello world";
        //input->read data->convert->write->outpur
        ByteArrayInputStream in = new ByteArrayInputStream(msg.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int value = -1;
        while((value = in.read())!=-1){
            int newValue =  Character.toUpperCase(value);
            out.write(newValue);
        }
        byte[] newData = out.toByteArray();
        System.out.println(new String(newData));
    }
}
