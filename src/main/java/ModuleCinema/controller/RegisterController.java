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

import java.io.IOException;
import java.util.Map;
import java.util.Random;

@Controller
@CrossOrigin
public class RegisterController {
    private final int AppID = 1400341372;

    private final String AppKey = "4f64c973f40e450534016ce13709dac0";

    private final int TemplateId = 565992;

    private final String SmsSign = "大小胖几的日常";

    @Autowired
    private RegisterService registerService;

    @ResponseBody
    @PostMapping("/a/post/register")
    public Result register(@RequestBody User user) {
        return null;
    }

    @ResponseBody
    @PostMapping("/a/post/register/sendMessage")
    public SmsSingleSenderResult sendMessage(@RequestBody Map<String, String> phoneNumber) {
        // 验证码
        String str = "";
        try {
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                str += random.nextInt(10);
            }
            // 短信中的变量
            String[] params = {str, "5"};
            SmsSingleSender sender = new SmsSingleSender(AppID, AppKey);
            SmsSingleSenderResult result = sender.sendWithParam("86",
                    phoneNumber.get("phoneNumber"), TemplateId, params, SmsSign, "", "");
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HTTPException e) {
            e.printStackTrace();
        }
        return null;
    }

}
