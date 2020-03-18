package ModuleCinema.service;

import ModuleCinema.pojo.User;

public interface HomeService {
    /**
     * 通过id查询用户数据
     * @param id
     * @return
     */
    User findUserByIdService(int id);
}
