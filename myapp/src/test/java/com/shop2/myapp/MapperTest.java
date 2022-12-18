package com.shop2.myapp;

import com.shop2.myapp.dto.NoticeDTO;
import com.shop2.myapp.model.NoticeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {

    @Autowired
    private NoticeMapper noticeMapper;

    @Test
    public void testNoticeList(){
    }

}
