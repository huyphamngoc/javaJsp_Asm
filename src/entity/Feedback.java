package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    private String userName;
    private String conTent;
    private int status;

    public Feedback() {
    }

    public Feedback(String userName, String conTent) {
        this.userName = userName;
        this.conTent = conTent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConTent() {
        return conTent;
    }

    public void setConTent(String conTent) {
        this.conTent = conTent;
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

        ArrayList<String> errorsContent = this.errors.get("content");

        if (errorsContent == null){
            errorsContent = new ArrayList<>();
        }

        if ( this.conTent == null || this.conTent.length() == 0 ){
            errorsContent.add("content is required!");
        }else if (this.conTent.length()<10 ){
            errorsContent.add("content is length min 10");
        }
        if (errorsContent.size()>0){
            this.errors.put("content",errorsContent);
        }
    }

    public HashMap<String,ArrayList<String>> getErrors(){
        return this.errors;
    }
}
