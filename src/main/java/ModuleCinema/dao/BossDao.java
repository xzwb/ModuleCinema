package ModuleCinema.dao;

import ModuleCinema.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BossDao {
    void deleteStaff(@Param("staffId") int staffId);

    void updateStaff(@Param("staffId") int staffId, @Param("staffGrade") String staffGrade);

    void insertStaff(Staff staff);

    // 获取头像文件路径
    String getStaffAvatar(@Param("staffId") int StaffId);
}
