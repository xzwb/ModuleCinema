package ModuleCinema.dao;

import ModuleCinema.pojo.Play;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     * 用户获取热门影片
     */
    List<Play> userGetHotPlay(@Param("page") int page);

    /**
     * 用户获取热门影片总数
     */
    int getHotPlayTotal();
}