package ModuleCinema.dao;

import ModuleCinema.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDao {
    /**
     * 将用户信息插入数据库
     * @param user
     */
    void registerUpdate(User user);
}
