package com.example.exchange路由模式;

import com.example.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class consumer1 {
    //消费者消费
    public static void main(String[] args) throws IOException {
        // 获取到连接以及mq通道
        Connection connection = RabbitMQUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare("hello",false,false,false,null);
        // 绑定队列到交换机
        channel.queueBind("routekey.1","topic", "routekey.*");
        // 监听队列
        channel.basicConsume("routekey.1",true,new DefaultConsumer(channel){
            @Override
            //重写方法打印消息
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("+++++++++++++++++++++"+new String(body));
            }
        });
    }
}
