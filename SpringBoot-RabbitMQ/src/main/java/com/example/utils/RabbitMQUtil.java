package com.example.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

//获取MQ的连接的工具类
public class RabbitMQUtil {

    public static ConnectionFactory connectionFactory;
    static {
        connectionFactory = new ConnectionFactory();//定义连接工厂
    }

    /**
     * 获取连接的工具类
     * @return
     */
    public static Connection getConnection(){
        try{
            connectionFactory.setHost("10.15.0.9");//设置服务地址
            connectionFactory.setPort(5672);//端口
            connectionFactory.setVirtualHost("/emp");//设置vhost
            connectionFactory.setUsername("emp");//用户名
            connectionFactory.setPassword("123456");//密码
            return connectionFactory.newConnection();// 通过工程获取连接
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接
     * @param channel
     * @param connection
     */
    public static void closeConnectionChannel(Channel channel,Connection connection){
        try{
            if(channel!=null){
                channel.close(); //关闭连接
            }
            if(connection!=null){
                connection.close(); //关闭连接
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
