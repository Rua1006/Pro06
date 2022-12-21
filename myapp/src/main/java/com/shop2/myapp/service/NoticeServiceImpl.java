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
    //공지사항 목록
    @Override
    public List<NoticeDTO> noticeList() throws Exception {
        return noticeMapper.noticeList();
    }
    //공지사항 세부정보
    @Override
    public NoticeDTO getNotice(int notiNo) throws Exception {
        return noticeMapper.getNotice(notiNo);
    }
    //공지사항 작성
    @Override
    public void noticeInsert(NoticeDTO dto) throws Exception {
        noticeMapper.noticeInsert(dto);
    }
}
