package com.ncu.contoller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ncu.jdbcDemo.Dao.CustomerDao;
import com.ncu.model.customer;
import com.ncu.model.user;

@Controller
@RequestMapping("/customer")
public class customercontroller {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new customer());
		
		return "customer-form";
	}
	
//	 @RequestMapping(value = "/user", method=RequestMethod.POST)
//	    public String save(@ModelAttribute("user") customer user, Model model)
//	    {
//	        try
//	        {
//	            if(CustomerDao.getcustomerById(user.getEmail()) != null);
//	            CustomerDao.Update( customer user);
//	        }
//	        catch(EmptyResultDataAccessException e)
//	        {
//	            System.out.println("inside catch");
//	            CustomerDao.save( customer user);
//	        }
//	        return ("redirect:/user");
//	    }
//	 
	 
	 
	@RequestMapping("/login")
	public String doregister(Model model) 
	{
		model.addAttribute("userModel",new user());
		return "customer-login";
	}
	
	@RequestMapping(path="/logined")
	public String login(@Valid @ModelAttribute("userModel") user user,BindingResult theBindingResult) 
	{
	
		if(theBindingResult.hasErrors())
		{
			return "customer-login";
		}
	
		else
		{
			System.out.println(user.getUsername());		
			return "interface";
		}	
	
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String formProcessing(@Valid @ModelAttribute("customerModel") customer custom,BindingResult theBindingResult,Model model)
	{
			System.out.println("First name: |"+custom.getFname()+"|");
		
		if(theBindingResult.hasErrors())
		{
			return "custome-form";
		}
		
		else
		{
			model.addAttribute("firstname",custom.getFname());
			model.addAttribute("email",custom.getEmail());
			
			System.out.println(custom);
			
			return "succesful";
		}	
	}
	
	@RequestMapping(value="/info", method = RequestMethod.GET)
	 public String userInfo(@SessionAttribute("customerModel") customer custom,Model model) {

		model.addAttribute("firstname",custom.getFname());
		model.addAttribute("email",custom.getEmail());
		model.addAttribute("phn",custom.getPno());
	      
	      return "sinfo";
	   }
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") customer theCustomer,
			BindingResult theBindingResult) {
		
		System.out.println("Last name: |" + theCustomer.getLname() + "|");
		
		if (theBindingResult.hasErrors()) {
			return "custome-form";
		}
		else {
			return "customer-confirmation";
		}
	}

}
