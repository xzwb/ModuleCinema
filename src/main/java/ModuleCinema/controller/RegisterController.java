package ModuleCinema.controller;

import ModuleCinema.dao.RegisterDao;
import ModuleCinema.pojo.User;
import ModuleCinema.service.RegisterService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @ResponseBody
    @GetMapping("/register")
    public Integer register(@RequestParam User user) {
        return registerService.registerService(user);
    }
}
