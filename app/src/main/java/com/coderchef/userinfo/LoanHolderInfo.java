package com.coderchef.userinfo;

/**
 * Created by riajur on 9/24/2014.
 */
public class LoanHolderInfo {
    private String name;
    private String phone;
    private String amount;
    private String address;
    private String start_date;
    private String end_date;
    private String loan_status;

    public LoanHolderInfo(){};
    public LoanHolderInfo(String name,String phone,String amount,String address, String start_date,String end_date,String loan_status){
        super();
        this.name = name;
        this.phone = phone;
        this.amount = amount;
        this.address = address;
        this.start_date = start_date; 
        this.end_date = end_date;
        this.loan_status =  loan_status;
    }

    public  String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public  String getAmount(){
        return this.amount;
    }

    public void setAmount(String amount){
        this.amount = amount;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getStart_date(){
        return this.start_date;
    }

    public void setStart_date(String start_date){
        this.start_date = start_date;
    }

    public String getEnd_date(){
        return this.end_date;
    }

    public void setEnd_date(String end_date){
        this.end_date = end_date;
    }

    public String getLoan_status(){
        return this.loan_status;
    }

    public void setLoan_status(String loan_status){
        this.loan_status = loan_status;
    }
}
