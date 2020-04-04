package ModuleCinema.dao;

import ModuleCinema.pojo.Play;
import ModuleCinema.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeDao {
    List<Play> homeDao();

    /**
     * 获取员工的集合
     * @param start
     * @return
     */
    List<Staff> selectStaff(@Param("start") int start);

    /**
     * 获取员工总数
     * @return
     */
    int staffTotal();
}
