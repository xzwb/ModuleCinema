package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@CrossOrigin(allowCredentials = "true")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * 用户注册
     * @param user 用户信息
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/a/post/register")
    public Result register(@RequestBody User user, HttpSession session) {
        // 取出session
        String sms = (String) session.getAttribute("sms");
        String phoneNumber = (String) session.getAttribute("phoneNumber");
        Result result =  registerService.registerService(user, sms, phoneNumber);
        // 如果注册成功删除session
        if (result.getState() == 200) {
            session.removeAttribute("sms");
        }
        return result;
    }

    /**
     * 给用户发送短信验证码
     * @param phoneNumber 用户手机号
     * @param session HttpSession
     * @return
     */
    @ResponseBody
    @PostMapping("/a/post/register/sendMessage")
    public Result sendMessage(@RequestBody Map<String, String> phoneNumber, HttpSession session) {
        return registerService.sendMessageService(phoneNumber.get("phoneNumber"), session);
    }

}
