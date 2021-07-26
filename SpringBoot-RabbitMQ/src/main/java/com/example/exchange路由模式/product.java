package com.example.exchange路由模式;

import com.example.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class product {
    public static void main(String[] args) throws IOException {
        // 获取到连接以及mq通道
        Connection connection = RabbitMQUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明exchange  topic 路由模式
        channel.exchangeDeclare("routekey.1", "topic");
        for (int i = 0; i < 10; i++) {
            // 发送消息内容
            channel.basicPublish("","routekey.1",null,"hello RabbitMQ".getBytes(StandardCharsets.UTF_8));
            System.out.println("发送了第"+i+"条消息！");
        }
        //关闭通道和连接
        RabbitMQUtil.closeConnectionChannel(channel,connection);
    }
}
