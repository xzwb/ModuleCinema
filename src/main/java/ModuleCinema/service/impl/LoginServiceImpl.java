package ModuleCinema.service.impl;

import ModuleCinema.dao.LoginDao;
import ModuleCinema.pojo.Boss;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
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

    @Override
    public Result loginServiceByBossId(int bossId, String bossPassword) {
        Boss boss = loginDao.loginSelectByBossId(bossId, bossPassword);
        Result result = new Result();
        if (boss == null) {
            result.setState(400);
            result.setMessage("用户名或密码不正确");
            return result;
        }
        result.setState(200);
        result.setMessage("校验成功");
        result.setData(boss);
        return result;
    }

    @Override
    public Result loginServiceByStaffId(int staffId, String staffPassword) {
        Staff staff = loginDao.loginSelectByStaffId(staffId, staffPassword);
        Result result = new Result();
        if (staff == null) {
            result.setState(400);
            result.setMessage("用户名或密码不正确");
            return result;
        }
        result.setState(200);
        result.setMessage("校验成功");
        result.setData(staff);
        return result;
    }
}
