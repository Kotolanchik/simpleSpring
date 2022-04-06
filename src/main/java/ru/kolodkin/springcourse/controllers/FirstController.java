package ru.kolodkin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/FIRST")
public class FirstController {

    @GetMapping("/hi")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("hi " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/gb")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname, Model model) {

        //System.out.println("bb " + name + " " + surname);
        model.addAttribute("message", "Bye " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calcPage(@RequestParam(value = "num1") int first,
                           @RequestParam(value = "num2") int second,
                           @RequestParam(value = "action") String action,
                           Model model) {
        double res = 0;
        switch (action) {
            case "add":
                res = first + second;
                break;
            case "*":
                res = first * second;
                break;
            case "-":
                res = first - second;
                break;
            case "/":
                res = first / (double) second;
                break;
            default:
                System.out.println("error");
                break;
        }


        model.addAttribute("calculateModel", first + " " + action + " " + second + " = " + res);

        return "first/calc";
    }
}
