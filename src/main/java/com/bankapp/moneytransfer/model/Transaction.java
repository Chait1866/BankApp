package com.bankapp.moneytransfer.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

    @JsonProperty("senderid")
    private  Long senderId;

    @JsonProperty("recieverid")
    private  Long recieverId;

    private  Double amount;


    public Transaction() {
    }

    public Transaction(Long senderId, Long recieverId, Double amount) {
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.amount = amount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Long recieverId) {
        this.recieverId = recieverId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
