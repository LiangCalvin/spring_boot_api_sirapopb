package com.sirapopb.sirapopb_api.dtos;

public class UpdateUserResponse {
    private String fname;
    private String lname;
    private Integer transId;

    public UpdateUserResponse(String fname, String lname, Integer transId) {
        this.fname = fname;
        this.lname = lname;
        this.transId = transId;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Integer getTransId() {
        return transId;
    }
}
