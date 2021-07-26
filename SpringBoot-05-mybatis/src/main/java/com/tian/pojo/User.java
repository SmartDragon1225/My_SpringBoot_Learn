package com.tian.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements RowMapper<User> {
   private int id;
   private String username;
   private String password;

    //  必须重写mapRow方法
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(1);
        user.setUsername("田智龙");
        user.setPassword("panzer1225");
        return user;
    }
}
