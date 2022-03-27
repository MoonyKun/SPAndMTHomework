package first_mq;

public class ProduceClient {

    /**
     * @param args
     */
    public static void main(String[] args)throws Exception {
        // TODO Auto-generated method stub
        MqClient client = new MqClient();
        client.produce("Hello Java");
    }
}
