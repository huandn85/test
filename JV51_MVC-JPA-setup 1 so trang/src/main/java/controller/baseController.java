package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class baseController {
    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "login")
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "addStudent")
    public String add() {
        return "user/addStudent";
    }

    @RequestMapping(value = "updateStudent")
    public String update() {
        return "user/updateStudent";
    }

    @RequestMapping(value = "listStudent")
    public String list() {
        return "user/listStudent";
    }
}
