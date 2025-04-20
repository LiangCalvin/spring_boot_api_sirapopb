package com.sirapopb.sirapopb_api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = false)
public class UpdateUserRequest {
//    @NotNull(message = "First name is required")
//    @Size(min = 2, message = "First name must have at least 2 characters")
    private String first_name;

//    @NotNull(message = "Last name is required")
    private String last_name;

    private Integer transId;


    public UpdateUserRequest(Integer transId, String last_name, String first_name) {
        this.transId = transId;
        this.last_name = last_name;
        this.first_name = first_name;
    }

    public UpdateUserRequest(String first_name, String last_name, Integer transId) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public UpdateUserRequest() {
        this.first_name = "Kim";
        this.last_name = "Ka";
        this.transId = 0;
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }
}
