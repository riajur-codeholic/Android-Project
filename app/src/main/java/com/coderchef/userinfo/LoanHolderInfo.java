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

    }
}
