import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MqClient {
    private final static int SERVER_PORT = 9999;
    //生产消息
    public static void produce(String msg) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),SERVER_PORT);
        try(
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){
            out.println(msg);
            out.flush();
        }
    }
    //消费消息
    public static String consume() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),SERVER_PORT);
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){
            //先向消息队列发送字符串"CONSUME"表示消费
            out.println("CONSUME");
            out.flush();
            //再从消息队列中获取一条消息
            String msg = in.readLine();
            return  msg;
        }
    }
}
