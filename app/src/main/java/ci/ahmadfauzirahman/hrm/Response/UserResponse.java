package ci.ahmadfauzirahman.hrm.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import ci.ahmadfauzirahman.hrm.Model.UserModel;

public class UserResponse {
    @SerializedName("con")
    @Expose
    private Boolean con;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("results")
    @Expose
    private UserModel results;

    public Boolean getCon() {
        return con;
    }

    public void setCon(Boolean con) {
        this.con = con;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserModel getResults() {
        return results;
    }

    public void setResults(UserModel results) {

        this.results = results;
    }
}
