package com.masum.jonogon;

public class UserModel {
    private  String rname,rmail,rpass;

    public UserModel(String rname, String rmail, String rpass) {
        this.rname = rname;
        this.rmail = rmail;
        this.rpass = rpass;
    }


    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRmail() {
        return rmail;
    }

    public void setRmail(String rmail) {
        this.rmail = rmail;
    }

    public String getRpass() {
        return rpass;
    }

    public void setRpass(String rpass) {
        this.rpass = rpass;
    }
}
