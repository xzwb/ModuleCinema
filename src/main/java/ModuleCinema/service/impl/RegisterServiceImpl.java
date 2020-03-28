package ModuleCinema.service.impl;

import ModuleCinema.dao.RegisterDao;
import ModuleCinema.pojo.User;
import ModuleCinema.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;

    @Override
    public Integer registerService(User user) {
        registerDao.registerUpdate(user);
        if (user.getUserId() != 0) {
           return user.getUserId();
        }
        return -1;
    }
}
