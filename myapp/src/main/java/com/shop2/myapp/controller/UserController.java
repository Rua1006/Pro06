package com.shop2.myapp.controller;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.dto.UserDTO;
import com.shop2.myapp.service.SampleService;
import com.shop2.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private HttpSession session;

    @GetMapping("/test1")
    public String userList1(Model model) throws Exception {
        List<UserDTO> list = userService.userList();
        model.addAttribute("list", list);
        return "user/test1";
    }

    @GetMapping("/idCheck.do")
    @ResponseBody
    public boolean idCheck(@RequestParam("id") String id) throws Exception {
        UserDTO user = userService.getUser(id);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/test2")
    public String userList2(Model model) throws Exception {
        return "user/test2";
    }

    @GetMapping("/userList.do")
    @ResponseBody
    public List<UserDTO> userList(Model model) throws Exception {
        List<UserDTO> userList = userService.userList();
        return userList;
    }

    @GetMapping("/test3")
    public String getUser(Model model) throws Exception {
        return "user/test3";
    }

    @GetMapping("/getUser.do")
    @ResponseBody
    public UserDTO getUser(@RequestParam("id") String id, Model model) throws Exception {
        UserDTO dto = userService.getUser(id);
        return dto;
    }

    @GetMapping("/test4")
    public String getLogin(Model model) throws Exception {
        return "user/test4";
    }

    //@PostMapping("getLogin.do")
    //@ResponseBody
    //public UserDTO getLogin(@ModelAttribute("user") UserDTO user, Model model) throws Exception {
    //UserDTO usr = userService.getLogin(user.getId(), user.getPw());
    // }

    @GetMapping("/getLogin.do")
    @ResponseBody
    public HttpSession getLogin(@RequestParam("id") String id, @RequestParam("pw") String pw) throws Exception {
        UserDTO user = userService.getLogin(id, pw);
        if(user==null) {
            session.invalidate();
        } else {
            session.setAttribute("sid", user.getId());
            session.setAttribute("svcnt", user.getVcnt());
        }
        return session;
    }
}
    