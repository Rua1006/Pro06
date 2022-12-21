package com.shop2.myapp.controller;

import com.shop2.myapp.dto.NoticeDTO;
import com.shop2.myapp.service.NoticeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.rmi.server.ExportException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    //공지사항 목록
    @GetMapping("/list")
    public String noticeList(Model model) throws Exception {
        List<NoticeDTO> noticeList = noticeService.noticeList();
        model.addAttribute("noticeList", noticeList);
        return "notice/noticeList";
    }
    //공지사항 세부정보
    @GetMapping("/detail")
    public String getNotice(@RequestParam("notiNo") int notiNo, Model model) throws Exception {
        NoticeDTO dto = noticeService.getNotice(notiNo);
        model.addAttribute("dto", dto);
        return "notice/noticeDetail";
    }
    @GetMapping("/insert")
    public String insertForm(HttpServletRequest request, Model model)throws Exception {
        return "notice/noticeInsert";
    }
    @PostMapping("/insert")
    public String noticeInsert(HttpServletRequest request, Model model)throws Exception {
        NoticeDTO dto = new NoticeDTO();
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        noticeService.noticeInsert(dto);
        return "redirect:list";
    }
}
