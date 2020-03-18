package ModuleCinema.dao;

import ModuleCinema.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeDao {
    User findUserByIdDao(int id);
}
