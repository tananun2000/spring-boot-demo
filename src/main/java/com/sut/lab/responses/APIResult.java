package com.sut.lab.responses;

import lombok.Data;

@Data
public class APIResult {

    public APIResult(String message){
        this.message = message;
    }

    private String message;

}
