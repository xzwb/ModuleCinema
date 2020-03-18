package ModuleCinema.service.impl;

import ModuleCinema.dao.HomeDao;
import ModuleCinema.pojo.User;
import ModuleCinema.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homeDao;

    @Override
    public User findUserByIdService(int id) {
        return homeDao.findUserByIdDao(id);
    }
}
