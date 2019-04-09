package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {

    private String userName;
    private String passWord;
    private String fullName;
    private int status;

    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Account(String userName, String passWord, String fullName) {
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
    }

    public Account(String fullName, String userName, String passWord, int status) {
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.status = status;
    }

    public Account(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private HashMap<String, ArrayList<String>> errors ;

    public boolean isValid(){
        validate();
        return this.errors.size()==0;
    }

    public void validate(){
        if (this.errors == null){
            this.errors = new HashMap<>();
        }

        ArrayList<String> errorsFullname = this.errors.get("fullname");

        if (errorsFullname == null){
            errorsFullname = new ArrayList<>();
        }

        if ( this.fullName == null || this.fullName.length() == 0 ){
            errorsFullname.add("fullname is required!");
        }else if (this.fullName.length()<2 || this.fullName.length()>30){
            errorsFullname.add("fullname is length 2-30");
        }
        if (errorsFullname.size()>0){
            this.errors.put("fullname",errorsFullname);
        }

        ArrayList<String> errorUser = this.errors.get("username");
        if (errorUser == null){
            errorUser = new ArrayList<>();
        }
        if (this.userName == null || this.userName.length() == 0){
            errorUser.add("Username is required!");
        }else if (this.userName.length()<2 || this.userName.length()>30){
            errorUser.add("username is length 2-30");
        }
        if (errorUser.size() > 0 ){
            this.errors.put("username", errorUser);
        }

        ArrayList<String> errorPass = this.errors.get("password");
        if (errorPass == null){
            errorPass = new ArrayList<>();
        }
        if (this.passWord == null || this.passWord.length() == 0){
            errorPass.add("password is required!");
        }else if (this.passWord.length()<2 || this.passWord.length()>30){
            errorPass.add("password is length 2-30");
        }
        if (errorPass.size() > 0 ){
            this.errors.put("password", errorPass);
        }
    }

    public HashMap<String,ArrayList<String>> getErrors(){
        return this.errors;
    }
}
