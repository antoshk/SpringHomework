package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.DocService;
import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.model.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/docs")
public class DocumentController {

    @Autowired
    private UserService userService;

    @Autowired
    private DocService docService;

    @GetMapping()
    public String getDocuments(ModelMap model){
        model.addAttribute("docs", docService.getDocuments());
        return "docs";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDoc(ModelMap model){
        model.addAttribute("newDoc", new DocumentDTO());
        return "addDoc";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveDoc(@Valid @ModelAttribute("newDoc") DocumentDTO newDoc, BindingResult result){
        if(result.hasErrors()){
            return "addDoc";
        }
        docService.addDocument(newDoc);
        return "redirect:/user/docs";
    }

    @RequestMapping(value = "/{docId}/edit", method = RequestMethod.GET)
    public String editDoc(@PathVariable Long docId, ModelMap model){
        model.addAttribute("doc", docService.getDocById(docId));
        return "editDoc";
    }

    @RequestMapping(value = "/{docId}/edit", method = RequestMethod.POST)
    public String updateDoc(@PathVariable Long docId, @Valid @ModelAttribute("doc") DocumentDTO doc, BindingResult result){
        if(result.hasErrors()){
            return "editDoc";
        }
        doc.setId(docId);
        docService.updateDoc(doc);
        return "redirect:/user/docs";
    }

    @RequestMapping(value = "/{docId}/delete", method = RequestMethod.POST)
    public String deleteDoc(@PathVariable Long docId){
        docService.deleteDoc(docId);
        return "redirect:/user/docs";
    }



}
