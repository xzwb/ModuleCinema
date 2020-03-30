package ModuleCinema.service.impl;

import ModuleCinema.dao.RegisterDao;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.service.RegisterService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@Service
public class RegisterServiceImpl implements RegisterService {
    private final int AppID = 1400341372;

    private final String AppKey = "4f64c973f40e450534016ce13709dac0";

    private final int TemplateId = 565992;

    private final String SmsSign = "大小胖几的日常";

    @Autowired
    private RegisterDao registerDao;

    @Override
    public Result registerService(User user, String sms) {
        Result result = new Result();
        if (!user.getSmsCode().equals(sms)) {
            result.setState(400);
            result.setMessage("验证码错误");
            return result;
        }
        registerDao.registerUpdate(user);
        if (user.getUserId() == 0) {
            result.setState(400);
            result.setMessage("注册失败");
            return result;
        }
        result.setState(200);
        result.setMessage("注册成功");
        result.setData(user.getUserId());
        return result;
    }

    @Override
    public Result sendMessageService(String phoneNumber, HttpSession session) {
        // 验证码
        String str = "";
        Result r = new Result();
        try {
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                str += random.nextInt(10);
            }
            // 短信中的变量
            String[] params = {str, "5"};
            SmsSingleSender sender = new SmsSingleSender(AppID, AppKey);
            SmsSingleSenderResult result = sender.sendWithParam("86",
                    phoneNumber, TemplateId, params, SmsSign, "", "");
            if (result.result == 0) {
                r.setState(200);
                r.setMessage("发送成功");
                session.setMaxInactiveInterval(6*60);
                session.setAttribute("sms", str);
            } else {
                r.setState(400);
                r.setMessage("发送失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HTTPException e) {
            e.printStackTrace();
        }
        return r;
    }
}
