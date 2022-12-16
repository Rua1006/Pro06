package com.shop2.myapp.model;

import com.shop2.myapp.dto.SampleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    public List<SampleDTO> findAll() throws Exception;
    public SampleDTO getSample(String id) throws Exception;
}
