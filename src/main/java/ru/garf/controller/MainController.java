package ru.garf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.garf.model.Art;
import ru.garf.service.ArticleService;

@Controller
@RequestMapping("/blog")
public class MainController {

    @Autowired
    private ArticleService service;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("articles", service.getAll());
        return "main";
    }

    @RequestMapping(value = "/editor")
    public String editorPage(Model model) {
        model.addAttribute("article", new Art());
        return "editor";
    }

    @RequestMapping(value = "/show/{article_id}")
    public String showArt(Model model, @PathVariable("article_id") Integer articleId) {
        model.addAttribute("title", service.getElement(articleId));
        return "show";
    }

    @RequestMapping(value = "/editor/submit", method = RequestMethod.POST)
    public String submitArticle(@ModelAttribute Art article) {
        service.save(article);
        System.out.println(article.getTypeArt());
        return "redirect:../";
    }

    @RequestMapping(value = "/btn", method = RequestMethod.POST)
    public String submitButton() {
        System.out.println("=========================================");
        return "redirect:https://vk.com/audios235636915?section=all";
    }

    @RequestMapping(value = "/delete/{article_id}")
    public String deteleArticle(@PathVariable("article_id") Integer articleId) {
        service.delete(articleId);
        return "redirect:../";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
