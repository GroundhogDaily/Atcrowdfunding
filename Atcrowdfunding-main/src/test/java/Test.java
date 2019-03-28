import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.manager.service.UserServer;
import com.atguigu.atcrowdfunding.util.MD5Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈加入用户数据〉
 *
 * @author chen
 * @create 2019/3/13
 */
public class Test {
    public static void main(String[] args) throws Exception{
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/spring*.xml");
        UserServer userServer = ioc.getBean(UserServer.class);
        for (int i = 0 ;i<100;i++){
            User user = new User();
            user.setLoginacct("test"+i);
            user.setEmail("test"+i+"@aaa.com");
            user.setUsername("test"+i);
            user.setUserpswd(MD5Util.digest("123"));
            user.setCreatetime("2019-03-13 12:23:22");
            userServer.saveUser(user);
        }
    }
}
