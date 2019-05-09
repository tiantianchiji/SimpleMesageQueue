public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(BrokerServer.SERVICE_PORT);
        while(true){
            BrokerServer server = new BrokerServer(socket.accept());
            new Thread(server).start();
        }
    }
}
