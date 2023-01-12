package com.masum.jonogon;

public class userHelper1 {
    String Name,Mname,Mnation,Fname,Fnation,DOB,Gender,Place_of_Birth,praddr,preaddr,Number;

    public userHelper1(String name, String mname, String mnation, String fname, String fnation, String DOB, String gender, String place_of_Birth, String praddr, String preaddr, String number) {
        Name = name;
        Mname = mname;
        Mnation = mnation;
        Fname = fname;
        Fnation = fnation;
        this.DOB = DOB;
        Gender = gender;
        Place_of_Birth = place_of_Birth;
        this.praddr = praddr;
        this.preaddr = preaddr;
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getMnation() {
        return Mnation;
    }

    public void setMnation(String mnation) {
        Mnation = mnation;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getFnation() {
        return Fnation;
    }

    public void setFnation(String fnation) {
        Fnation = fnation;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPlace_of_Birth() {
        return Place_of_Birth;
    }

    public void setPlace_of_Birth(String place_of_Birth) {
        Place_of_Birth = place_of_Birth;
    }

    public String getPraddr() {
        return praddr;
    }

    public void setPraddr(String praddr) {
        this.praddr = praddr;
    }

    public String getPreaddr() {
        return preaddr;
    }

    public void setPreaddr(String preaddr) {
        this.preaddr = preaddr;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
