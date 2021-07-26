package com.tian.IocConfig;

import com.tian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.Test;

@Configuration
public class UserConfig {
    @Bean("user1")
    public User user(){
         User user = new User();
         user.setId(1);
         user.setName("田智龙");
         return user;
    }


}
