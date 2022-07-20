package user.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    //Data members

    private String uname;

    private String pword;

    //Getters & Setters

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    //Constructor
    public User(){}

    public User(@JsonProperty("uname") String uname,
                @JsonProperty("pword") String pword){
        this.uname = uname;
        this.pword = pword;
    }

    //Overriding toString
    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pword='" + pword + '\'' +
                '}';
    }
}


