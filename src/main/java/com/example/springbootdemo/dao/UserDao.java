package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate template;

    public List<User> findUser(String sno,String password){
        String sql = "SELECT * FROM user WHERE sno=? and password=?";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class),
                sno,
                password);
    }

    public int insertUser(User user) {
        String sql="insert into user (`sno`,`username`,`password`,`phonenumber`,`realname`,`marjoy`,`balance`) values (?,?,?,?,?,?,?)";
        return template.update(sql,user.getSno(),user.getUsername(),user.getPassword(),user.getPhonenumber(),user.getRealname(),user.getMarjoy(),user.getBalance());
    }

    public List<User> findSellerByPid(String sno) {
        String sql="select * from user where sno=?";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),sno);
    }
}
