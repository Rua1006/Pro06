package com.shop2.myapp.model;

import com.shop2.myapp.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeDTO> noticeList();
    NoticeDTO getNotice(int notiNo);

}
