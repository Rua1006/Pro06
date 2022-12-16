package com.shop2.myapp.controller;

import com.shop2.myapp.dto.NoticeDTO;
import com.shop2.myapp.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.rmi.server.ExportException;
import java.util.List;

@Controller
@RequestMapping("/notice/")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @GetMapping("list")
    public String noticeList(Model model) throws Exception {
        List<NoticeDTO> noticeList = noticeService.noticeList();
        model.addAttribute("noticeList", noticeList);
        return "/notice/noticeList";
    }
}
