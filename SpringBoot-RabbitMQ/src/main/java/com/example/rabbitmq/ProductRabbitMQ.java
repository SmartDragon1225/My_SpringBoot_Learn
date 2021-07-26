package com.example.rabbitmq;

import com.example.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import javafx.collections.ListChangeListener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ProductRabbitMQ {
    //生产者生产消息
    public static void main(String[] args) throws IOException {
        // 获取到连接以及mq通道
        Connection connection = RabbitMQUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明（创建）队列
        channel.queueDeclare("hello",false,false,false,null);
        // 发送消息内容
        channel.basicPublish("","hello",null,"hello RabbitMQ".getBytes(StandardCharsets.UTF_8));
        //关闭通道和连接
        RabbitMQUtil.closeConnectionChannel(channel,connection);
    }
}
