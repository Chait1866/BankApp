package com.bankapp.moneytransfer.model;


public class Response {
    private Double senderBalance;
    private String senderName;
    private Double recieverBalance;
    private String recieverName;

    public Response(Double senderBalance, String senderName, Double recieverBalance, String recieverName) {
        this.senderBalance = senderBalance;
        this.senderName = senderName;
        this.recieverBalance = recieverBalance;
        this.recieverName = recieverName;
    }

    public Double getSenderBalance() {
        return senderBalance;
    }

    public void setSenderBalance(Double senderBalance) {
        this.senderBalance = senderBalance;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Double getRecieverBalance() {
        return recieverBalance;
    }

    public void setRecieverBalance(Double recieverBalance) {
        this.recieverBalance = recieverBalance;
    }

    public String getRecieverName() {
        return recieverName;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName = recieverName;
    }
}
