package org.gday.appa.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("result", "stuff here");
        return "home";
    }
}
