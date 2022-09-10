package com.presidents.controller;

import com.presidents.model.dto.PresidentDto;
import com.presidents.model.entity.President;
import com.presidents.repository.PresidentsRepository;
import com.presidents.service.president.PresidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PresidentsControllerThymeleaf {

   private final PresidentsRepository presidentsRepository;
   private final PresidentService presidentService;

//    @GetMapping("/")
//    public String getIndex( Model model){
//        model.addAttribute("name", "Agata");
//        model.addAttribute("imiona", Arrays.asList("Alessandro", "Lola"));
//        return "index";
//    }

    @GetMapping("/")
    public String getIndex(Model model, @RequestParam(name = "form", required = false, defaultValue = "false")
    Boolean form){
        model.addAttribute("presidents",presidentsRepository.findAll());
        model.addAttribute("presidentDto", new PresidentDto());
        model.addAttribute("form", form);
        return "index";
    }
    @PostMapping("save")
    public String save(@ModelAttribute("presidentDto") PresidentDto presidentDto, Model model) {
        presidentService.savePresident(presidentDto);
        return "redirect:/";
    }
}
