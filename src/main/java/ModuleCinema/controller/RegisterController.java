package ModuleCinema.controller;

import ModuleCinema.dao.RegisterDao;
import ModuleCinema.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.Date;

@Controller
@CrossOrigin
public class RegisterController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @ResponseBody
    @GetMapping("/register")
    public int register() {
        User user = new User();
        user.setBirthday(new Date(20000505));
        user.setUserName("xzwb");
        user.setUserSex("男");
        user.setUserPassword("123456");
        user.setSecurityQuestion("789456");
        user.setClassifiedAnswer("8888");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RegisterDao registerDao = sqlSession.getMapper(RegisterDao.class);
        registerDao.registerUpdate(user);
        sqlSession.commit();
        System.out.println(user.getUserId());
        return 1;
    }
}
