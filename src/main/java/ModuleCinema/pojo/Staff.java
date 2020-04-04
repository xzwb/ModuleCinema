package ModuleCinema.pojo;

import java.util.List;

public class Staff {
    private int staffId;
    private String staffName;
    private String staffGrade;
    private String staffPassword;
    // 员工照片所在的uri
    private String staffAvatar;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffGrade() {
        return staffGrade;
    }

    public void setStaffGrade(String staffGrade) {
        this.staffGrade = staffGrade;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffAvatar() {
        return staffAvatar;
    }

    public void setStaffAvatar(String staffAvatar) {
        this.staffAvatar = staffAvatar;
    }
}
