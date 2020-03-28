package ModuleCinema.pojo;

import java.util.Date;

public class User {
    // 用户唯一标示
    private int userId;
    // 用户昵称
    private String userName;
    // 用户头像路径
    private String avatar;
    // 用户角色id (管理员, 游客, 经理)
    private int roleId;
    // 用户生日
    private Date birthday;
    // 用户密码
    private String userPassword;
    // 用户性别
    private String userSex;
    // 用户密保问题
    private String securityQuestion;
    // 用户密保答案
    private String classifiedAnswer;


    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String  toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleId=" + roleId +
                ", birthday=" + birthday +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", securityQuestion='" + securityQuestion + '\'' +
                ", classifiedAnswer='" + classifiedAnswer + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getClassifiedAnswer() {
        return classifiedAnswer;
    }

    public void setClassifiedAnswer(String classifiedAnswer) {
        this.classifiedAnswer = classifiedAnswer;
    }
}
