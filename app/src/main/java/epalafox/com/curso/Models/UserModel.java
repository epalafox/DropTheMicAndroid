package epalafox.com.curso.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by epalafox on 12/08/2017.
 */

public class UserModel {
    @SerializedName("Id")
    int id;
    @SerializedName("UserName")
    String userName;
    @SerializedName("Password")
    String password;
    @SerializedName("Gender")
    int gender;
    @SerializedName("Birthday")
    String birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
