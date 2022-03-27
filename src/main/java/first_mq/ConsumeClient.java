package first_mq;

public class ConsumeClient {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        MqClient client = new MqClient();
        String message = client.consume();
        System.out.println("获取的消息为： "+message);
    }
}
