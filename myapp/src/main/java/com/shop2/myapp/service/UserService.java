package com.shop2.myapp.service;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.dto.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> userList() throws Exception;
    public UserDTO getUser(String id) throws Exception;
    public UserDTO getLogin(String id, String pw) throws Exception;
}
