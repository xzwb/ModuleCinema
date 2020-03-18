package ModuleCinema.service.impl;

import ModuleCinema.dao.LoginDao;
import ModuleCinema.pojo.User;
import ModuleCinema.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public boolean loginService(User user) {
        User newUser = loginDao.judgeLoginInformation(user);
        if (newUser == null) {
            return false;
        } else {
            return true;
        }
    }
}
