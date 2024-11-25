package com.example.moodify.controller;

import com.example.moodify.model.Mood;
import com.example.moodify.model.MoodService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@Controller
public class MoodController {

    @Autowired
    private ApplicationContext context;

    // Página principal (carrega todos os moods)
    @GetMapping("/")
    public String index(Model model) {
        MoodService md = context.getBean(MoodService.class);
        model.addAttribute("mood", new Mood());
        model.addAttribute("moods", md.listarMoods());
        return "index"; // Renderiza a única página
    }

    // Adicionar um novo mood
    @PostMapping("/moods/add")
    public String addMood(@ModelAttribute Mood mood) {
        MoodService md = context.getBean(MoodService.class);
        md.inserirMood(mood);
        return "redirect:/";
    }

    // Atualizar um mood
    @PostMapping("/moods/update/{id}")
    @ResponseBody
    public String updateMood(@PathVariable("id") int id
        , Model model
        , @ModelAttribute Mood mod){
            MoodService md = context.getBean(MoodService.class);
            md.atualizarMood(id, mod);
            return "redirect:/";
        }
    

    // Excluir um mood
    @PostMapping("/moods/delete/{id}")
    public String deleteMood(@PathVariable("id") int id) {
        MoodService md = context.getBean(MoodService.class);
        md.apagarMood(id);
        return "redirect:/";
    }
}

