package com.shop2.myapp.service;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.dto.UserDTO;
import com.shop2.myapp.model.SampleMapper;
import com.shop2.myapp.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper UserMapper;

    @Override
    public List<UserDTO> userList() throws Exception {
        return UserMapper.userList();
    }

    @Override
    public UserDTO getUser(String id) throws Exception {
        return UserMapper.getUser(id);
    }

    @Override
    public UserDTO getLogin(String id, String pw) throws Exception {
        return UserMapper.getLogin(id, pw);
    }
}