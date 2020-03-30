package ModuleCinema.service;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;

import javax.servlet.http.HttpSession;

public interface RegisterService {
    /**
     * 注册
     * @param user 用户信息
     * @param sms session中保存的短信验证码
     * @return
     */
    Result registerService(User user, String sms, String phoneNumber);

    Result sendMessageService(String phoneNumber, HttpSession session);
}
