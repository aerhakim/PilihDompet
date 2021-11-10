package io.github.aerhakim.pilihdompet.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchUserResponse {

    @SerializedName("users")
    List<io.github.aerhakim.pilihdompet.model.User> userList;
    String error;

    public FetchUserResponse(List<io.github.aerhakim.pilihdompet.model.User> userList, String error) {
        this.userList = userList;
        this.error = error;
    }

    public List<io.github.aerhakim.pilihdompet.model.User> getUserList() {
        return userList;
    }

    public void setUserList(List<io.github.aerhakim.pilihdompet.model.User> userList) {
        this.userList = userList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
