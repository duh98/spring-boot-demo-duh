package com.xkcoding.orm.mybatis;

import cn.hutool.core.util.StrUtil;
import com.xkcoding.orm.mybatis.entity.User;
import com.xkcoding.orm.mybatis.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 10:52
 */
//@MapperScan(basePackages = {"com.xkcoding.orm.mybatis.mapper"})
@SpringBootApplication
@RestController
public class SpringBootDemoOrmMybatisApplication {
  @Autowired
  UserMapper userMapper;
  public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoOrmMybatisApplication.class, args);
    }
  @GetMapping("/hello")
  public String sayHello(@RequestParam(required = true, name = "who") Long who) {
    if (null != who) {
      User user = userMapper.selectUserById(who);
      return user.toString();
    }
    return "null";
  }
}
