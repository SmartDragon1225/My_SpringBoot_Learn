package com.example.work;

import com.example.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 测试结果：
 * 1、消费者1和消费者2获取到的消息内容是不同的，同一个消息只能被一个消费者获取。
 * 2、消费者1和消费者2获取到的消息的数量是相同的，一个是消费奇数号消息，一个是偶数。
 */
public class Product {
    public static void main(String[] args) throws IOException {
        // 获取到连接以及mq通道
        Connection connection = RabbitMQUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明（创建）队列
        channel.queueDeclare("hello",false,false,false,null);
        for (int i = 0; i < 10; i++) {
            // 发送消息内容
            channel.basicPublish("","hello",null,"hello RabbitMQ".getBytes(StandardCharsets.UTF_8));
            System.out.println("发送了第"+i+"条消息！");
        }
        //关闭通道和连接
        RabbitMQUtil.closeConnectionChannel(channel,connection);
    }
}
