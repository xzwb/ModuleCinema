package ModuleCinema.controller;

import ModuleCinema.dao.RegisterDao;
import ModuleCinema.pojo.User;
import ModuleCinema.service.RegisterService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @ResponseBody
    @PostMapping("/register")
    public Integer register(@RequestBody User user) {
        return registerService.registerService(user);
    }
}
