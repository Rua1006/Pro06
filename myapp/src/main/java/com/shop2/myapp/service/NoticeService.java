package com.shop2.myapp.service;

import com.shop2.myapp.dto.NoticeDTO;

import java.util.List;

public interface NoticeService {
    public List<NoticeDTO> noticeList() throws Exception;
    public NoticeDTO getNotice(int notiNo) throws Exception;
}
