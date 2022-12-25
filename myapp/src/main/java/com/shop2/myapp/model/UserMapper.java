package com.shop2.myapp.model;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserDTO> userList() throws Exception;
    public UserDTO getUser(String userid) throws Exception;
    public UserDTO getLogin(String userid, String userpw)throws Exception;
    public void insertUser(UserDTO user)throws Exception;
}
