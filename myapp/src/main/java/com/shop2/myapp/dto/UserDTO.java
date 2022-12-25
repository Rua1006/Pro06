package com.shop2.myapp.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int userSeq;
    private String userId;
    private String userPw;
    private String userName;
    private String email;
    private String regdate;
}
