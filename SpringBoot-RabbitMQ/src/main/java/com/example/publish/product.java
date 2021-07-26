package com.example.publish;

import com.example.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 1、1个生产者，多个消费者
 * 2、每一个消费者都有自己的一个队列
 * 3、生产者没有将消息直接发送到队列，而是发送到了交换机
 * 4、每个队列都要绑定到交换机
 * 5、生产者发送的消息，经过交换机，到达队列，实现，一个消息被多个消费者获取的目的
 * 注意：一个消费者队列可以有多个消费者实例，只有其中一个消费者实例会消费
 */
//订阅模式
public class product {
    public static void main(String[] args) throws IOException {
        // 获取到连接以及mq通道
        Connection connection = RabbitMQUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明exchange
        channel.exchangeDeclare("hello", "fanout");
        for (int i = 0; i < 10; i++) {
            // 发送消息内容
            channel.basicPublish("","hello",null,"hello RabbitMQ".getBytes(StandardCharsets.UTF_8));
            System.out.println("发送了第"+i+"条消息！");
        }
        //关闭通道和连接
        RabbitMQUtil.closeConnectionChannel(channel,connection);
    }
}
