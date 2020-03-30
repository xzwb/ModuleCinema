package ModuleCinema.service;

import ModuleCinema.pojo.Result;

public interface LoginService {

    /**
     * 使用电话进行登录
     * @param phoneNumber
     * @param userPassword
     * @return
     */
    Result loginServiceByPhoneNumber(String phoneNumber, String userPassword);

    /**
     * 使用账户进行登录
     * @param userId
     * @param userPassword
     * @return
     */
    Result loginServiceByUserId(int userId, String userPassword);
}
