package com.shop2.myapp.service;

import com.shop2.myapp.dto.NoticeDTO;
import com.shop2.myapp.model.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<NoticeDTO> noticeList() throws Exception {
        return noticeMapper.noticeList();
    }
}
