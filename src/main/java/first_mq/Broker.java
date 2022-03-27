package first_mq;

import  java.util.concurrent.ArrayBlockingQueue ;
//消息处理中心
public class Broker {
    //ArrayBlockingQueue为Queue的一个子类，提供了数据的插入，获取查询等操作。
    //其底层数据将以数组的形式保存。
    private  final  static  int  MAX_SIZE  =  3;
    private  static  ArrayBlockingQueue<String>  messageQueue = new ArrayBlockingQueue(MAX_SIZE) ;

    public  static  void  produce(String  msg){
        if(messageQueue.offer(msg)){//offer（）为插入操作。
            System.out.println("成功向消息处理中心投递消息："+msg+", 当前暂存的消息数量是： " + messageQueue.size());
        }
        else{
            System.out.println("暂存的消息达到最大负荷，不能继续放入消息！");
        }

        System.out.println("=================");
    }

    public  static  String  consume(){
        String msg = messageQueue.poll();//poll（）负责删除数据，并返回队列头部元素。

        if(msg!=null){
            System.out.println("已经消费消息： "+ msg +", 当前暂存的消息数量是： "+messageQueue.size());
        }else{
            System.out.println("消息处理中心内没有消息可供消费！");
        }

        System.out.println("=================");
        return msg;
    }

}

