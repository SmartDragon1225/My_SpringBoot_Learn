package com.tian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//缓存
// 要缓存的 Java 对象必须实现 Serializable 接口，因为 Spring 会将对象先序列化再存入 Redis
public class User implements Serializable {
    private int id;
    private String username;
    private int password;
}
