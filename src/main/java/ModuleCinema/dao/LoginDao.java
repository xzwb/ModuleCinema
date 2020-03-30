package ModuleCinema.dao;

import ModuleCinema.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    /**
     * 用手机号做登录验证
     * @param phoneNumber
     * @param userPassword
     * @return
     */
    User loginSelectByPhoneNumber(@Param("phoneNumber") String phoneNumber,
                                  @Param("userPassword") String userPassword);

    /**
     * 用账号做登录验证
     * @param userId
     * @param userPassword
     * @return
     */
    User loginSelectByUserId(@Param("userId") int userId,
                             @Param("userPassword") String userPassword);
}
