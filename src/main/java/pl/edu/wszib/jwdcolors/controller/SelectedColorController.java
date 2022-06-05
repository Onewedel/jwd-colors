package pl.edu.wszib.jwdcolors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.jwdcolors.dao.SelectedColorDao;
import pl.edu.wszib.jwdcolors.model.SelectedColor;
import pl.edu.wszib.jwdcolors.service.SelectedColorService;

import java.util.Date;

@Controller
public class SelectedColorController {

    @Value("${app.title.select}")
    private String title;

    @Autowired
    SelectedColorService selectedColorService;

    @GetMapping({"/select", "/select/{color}"})
    public String selectColorPage(@PathVariable(required = false) String color, Model model) {

        if (color !=null && !color.isEmpty()){
           selectedColorService.save(color);
        }


        String[][] colors = {
                {"red","blue","purple","teal"},
                {"black","orange","yellow","green"},
                {"gray","silver","olive","lime"},
                {"navy","white","aqua","fuchsia"},
        };

        model.addAttribute("title", title);
        model.addAttribute("colors", colors);
        return "select";
    }
    @GetMapping("/")
    String showIndex() {
        return "redirect:select";
    }
}
