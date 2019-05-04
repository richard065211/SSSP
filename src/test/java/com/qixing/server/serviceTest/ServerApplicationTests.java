package com.qixing.server.serviceTest;

import com.qixing.server.pojo.User;
import com.qixing.server.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = {"classpath:META-INF/applicationContext.xml"})
public class ServerApplicationTests {

    @Autowired
    UserService userService;
    @Test
    public void  test01() {
        User user=userService.getUserInfo(4);
        System.out.println(user.toString());
    }

    @Test
    public void select(){
            String  result=userService.login("15170038583");
            System.out.println(result);
    }
    @Test
    public void register(){
        userService.register("richard","12345");
    }
    @Test
    public void resetPassword(){
       String string = userService.resetPassword("richard","15170038583");
       System.out.println(string);
    }
    @Test
    public void test() throws SQLException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        DataSource data = applicationContext.getBean(DataSource.class);
        System.out.println(data.getConnection().toString());
    }
}
