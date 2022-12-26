package com.shop2.myapp.controller;

import com.shop2.myapp.dto.SampleDTO;
import com.shop2.myapp.dto.UserDTO;
import com.shop2.myapp.service.SampleService;
import com.shop2.myapp.service.UserService;
import com.shop2.myapp.util.AES256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public boolean idCheck(@RequestParam("userId") String userid) throws Exception {
        UserDTO user = userService.getUser(userid);
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

    //@PostMapping("getLogin.do")
    //@ResponseBody
    //public UserDTO getLogin(@ModelAttribute("user") UserDTO user, Model model) throws Exception {
    //UserDTO usr = userService.getLogin(user.getId(), user.getPw());
    // }
    @GetMapping("/join")
    public String insertUser(HttpServletRequest request, Model model) throws Exception {
        return "user/join";
    }

    @PostMapping("/joinUser")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model) throws Exception {
        AES256 aes256 = new AES256();
        user.setUserPw(aes256.encrypt(user.getUserPw()));
        userService.insertUser(user);
        return "redirect:/";
    }

    @GetMapping("/loginForm")
    public String getLogin(HttpServletRequest request, Model model) throws Exception {
        return "user/loginForm";
    }

    @GetMapping("/getLogin.do")
    @ResponseBody
    public UserDTO getLogin(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, Model model) throws Exception {
        AES256 aes256 = new AES256();
        userPw = aes256.encrypt(userPw);
        UserDTO user = userService.getLogin(userId, userPw);
        if (user == null) {
            session.invalidate();
        } else {
            session.setAttribute("sid", user.getUserId());
            session.setAttribute("sname", user.getUserName());
        }
        return user;
    }

    @RequestMapping("/logout")
    public String userLogout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }
}
    