package ModuleCinema.service;

import ModuleCinema.pojo.User;

public interface LoginService {
    /**
     * 登录校验的service层
     * @param user
     * @return
     */
    boolean loginService(User user);
}
