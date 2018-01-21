package com.gmail.shelkovich.anton.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.gmail.shelkovich.anton.bean.StudentService;
import com.gmail.shelkovich.anton.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private StudentService service;

	@Autowired
	public JavaMailSender emailSender;

	@RequestMapping(value="/")
	public String homePage(ModelMap model, HttpSession session) throws IOException{

		return "home";
	}

	@RequestMapping(value="/generate", method = RequestMethod.POST)
	public String generate(ModelMap model, HttpSession session) throws IOException{
		List<Student> students = (List<Student>) session.getAttribute("studentList");
		if (students == null){
			students = new ArrayList<>();
		}
		students.addAll(service.getStudents());
		session.setAttribute("studentList", students);
		return "redirect:/";
	}

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String showAddStudentForm(ModelMap model, HttpSession session) throws IOException{
		model.addAttribute("newStudent", new Student());
		return "add";
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult result, ModelMap model, HttpSession session) throws IOException{
		if (result.hasErrors()) {
			return "error";
		}
		List<Student> students = (List<Student>) session.getAttribute("studentList");
		if (students == null){
			students = new ArrayList<>();
		}
		students.add(student);
		session.setAttribute("studentList", students);
		return "redirect:/";
	}

	@RequestMapping(value="/email", method = RequestMethod.GET)
	public String showEmailForm(ModelMap model) throws IOException{
		return "email";
	}

	@RequestMapping(value="/email", method = RequestMethod.POST)
	public String sendEmail(ModelMap model) throws IOException{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("anton.shelkovich@gmail.com");
		message.setSubject("ee project feedback notice");
		message.setText("It's pleasure to notice you that email sending is working!");
		emailSender.send(message);

		return "redirect:/";
	}
}
