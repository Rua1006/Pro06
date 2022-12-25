package com.shop2.myapp.service;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.dto.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> userList() throws Exception;
    public UserDTO getUser(String userid) throws Exception;
    public UserDTO getLogin(String userid, String userpw) throws Exception;
    public void insertUser(UserDTO user) throws Exception;
}
