package com.example.work;

import com.example.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer1 {
    //消费者消费
    public static void main(String[] args) throws IOException {
        // 获取到连接以及mq通道
        Connection connection = RabbitMQUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare("hello",false,false,false,null);
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        //监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            //重写方法打印消息
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);
                try {
                    Thread.sleep(5); //模拟出故障
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("+++++++++++++++++++++"+new String(body));
            }
        });
   }
}
