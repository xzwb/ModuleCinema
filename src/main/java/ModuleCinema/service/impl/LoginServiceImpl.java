package ModuleCinema.service.impl;

import ModuleCinema.dao.LoginDao;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    @Override
    public Result loginServiceByPhoneNumber(String phoneNumber, String userPassword) {
        User user = loginDao.loginSelectByPhoneNumber(phoneNumber, userPassword);
        Result result = new Result();
        if (user == null) {
            result.setState(400);
            result.setMessage("用户名或者密码不正确");
            return result;
        }
        result.setState(200);
        result.setMessage("登录校验成功");
        result.setData(user);
        return result;
    }

    @Override
    public Result loginServiceByUserId(int userId, String userPassword) {
        User user = loginDao.loginSelectByUserId(userId, userPassword);
        Result result = new Result();
        if (user == null) {
            result.setState(400);
            result.setMessage("用户名或者密码不正确");
            return result;
        }
        result.setState(200);
        result.setMessage("登录校验成功");
        result.setData(user);
        return result;
    }
}
