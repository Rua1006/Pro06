package com.shop2.myapp.model;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserDTO> userList() throws Exception;
    public UserDTO getUser(String id) throws Exception;
    public UserDTO getLogin(String id, String pw)throws Exception;
}
