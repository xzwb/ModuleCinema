package ModuleCinema.service;

import ModuleCinema.pojo.User;

public interface RegisterService {
    /**
     * 注册的service层 成功返回账号 不成功返回-1
     * @param user
     * @return
     */
    Integer registerService(User user);
}
