import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("请输入1或2选择写入还是取出:");
        System.out.println("1.写入消息  2.消费消息");
        int in;
        int i = 1;
        while(( in = new Scanner(System.in).nextInt())!=-1){
            if(in==1){//写入消息
                MqClient mqClient = new MqClient();
                mqClient.produce("Hello world-"+i);
                i++;
            }else if(in==2){
                MqClient mqClient = new MqClient();
                String msg = mqClient.consume();
                System.out.println("获取的消息是："+msg);
            }else{
                System.out.println("请输入正确的选项");
            }
            System.out.println("请输入1或2选择写入还是取出:");
            System.out.println("1.写入消息  2.消费消息");

        }
    }
}
