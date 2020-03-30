package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.service.RegisterService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

@Controller
@CrossOrigin
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @ResponseBody
    @PostMapping("/a/post/register")
    public Result register(@RequestBody User user, HttpSession session) {
        String sms = (String) session.getAttribute("sms");
        Result result =  registerService.registerService(user, sms);
        if (result.getState() == 200) {
            session.removeAttribute("sms");
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/a/post/register/sendMessage")
    public Result sendMessage(@RequestBody Map<String, String> phoneNumber, HttpSession session) {
        return registerService.sendMessageService(phoneNumber.get("phoneNumber"), session);
    }

}
