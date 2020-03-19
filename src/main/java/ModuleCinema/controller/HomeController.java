package ModuleCinema.controller;

import ModuleCinema.pojo.User;
import ModuleCinema.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class HomeController {
    @Autowired
    private HomeService homeService;

    @ResponseBody
    @GetMapping("/home/{id}")
    public User home(@PathVariable int id) {
        return homeService.findUserByIdService(id);
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "1";
    }
}
