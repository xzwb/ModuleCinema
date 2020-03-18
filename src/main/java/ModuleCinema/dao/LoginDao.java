package ModuleCinema.dao;

import ModuleCinema.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    /**
     * 做登录校验
     * @param user
     * @return
     */
    User judgeLoginInformation(User user);
}
