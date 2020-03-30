package ModuleCinema.service.impl;

import ModuleCinema.dao.RegisterDao;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.service.RegisterService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 做注册时验证码的校验
     * @param user 用户信息
     * @param sms session中保存的短信验证码
     * @return
     */
    @Override
    public Result registerService(User user, String sms) {
        Result result = new Result();
        if (!user.getSmsCode().equals(sms)) {
            result.setState(400);
            result.setMessage("验证码错误");
            return result;
        }
        registerDao.registerUpdate(user);
        // 这种是验证码正确但是注册失败的情况
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

    /**
     * 给用户手机发送短信验证码
     * @param phoneNumber
     * @param session
     * @return
     */
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
                // 设置session存活时间
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
