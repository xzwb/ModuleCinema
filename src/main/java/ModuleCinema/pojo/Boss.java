package ModuleCinema.pojo;

import java.util.List;

/**
 * 经理表
 */
public class Boss {
    private int bossId;
    private String bossName;
    private String bossPassword;

    private List<Staff> staffList;

    public int getBossId() {
        return bossId;
    }

    public void setBossId(int bossId) {
        this.bossId = bossId;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getBossPassword() {
        return bossPassword;
    }

    public void setBossPassword(String bossPassword) {
        this.bossPassword = bossPassword;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
