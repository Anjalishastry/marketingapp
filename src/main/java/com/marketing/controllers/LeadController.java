package com.marketing.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.leaddata;
import com.marketing.entities.lead;
import com.marketing.services.LeadService;
import com.marketing.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	//handler methods
	
	//http://localhost:8080/create
	
	@RequestMapping("/create")
	public String viewCreateLoadForm()
	{
		return"create_lead";
	}
	
	//FIRST WAY
	//http://localhost:8080/saveLead
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead")lead lead, Model model) 
	{
		model.addAttribute("msg","record is saved!");
		emailService.sendEmail(lead.getEmail(),"WELCOME","you are defaulter");
		leadService.saveOneLead(lead);
//		em.out.println(lead.getMobile());
			
		return"create_lead";
	}
	
	//SECOND WAY
	//http://localhost:8080/saveLead
//	@RequestMapping("/saveLead")
//	public String saveLead(@RequestParam("firstName") String firstName,@RequestParam("lastName")String lastName,@RequestParam("email")String Email,@RequestParam("mobile")long mobile) {
////		System.out.println(firstName);
////		System.out.println(lastName);
////		System.out.println(Email);
////		System.out.println(mobile);
//		lead lead= new lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(Email);
//		lead.setMobile(mobile);
//		leadService.saveOneLead(lead);
//		return"create_lead";
//	}
	
//	//THIRD WAY
//	@RequestMapping("/saveLead")
//	
//	public String saveLead(leaddata leadData) {
//		lead lead = new lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());
//		leadService.saveOneLead(lead);
//		return"create_lead";
//	}
	
	//http:localhost:8080/listall
	
	@RequestMapping("/listall")
	public String listLeads(Model model) {
		List<lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		//System.out.println(leads);
		return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteOnelead(@RequestParam("id") long id, Model model) {
		leadService.deleteLead(id);
		
		List<lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		//System.out.println(leads);
		return "list_leads";
	}
	
	@RequestMapping("/update")
	public String updateOnelead(@RequestParam("id") long id, Model model) {
		lead lead = leadService.getLeadbyId(id);
		model.addAttribute("leads", lead);

		return "update_leads";
		
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(@ModelAttribute("lead")lead lead, Model model) 
	{
		leadService.saveOneLead(lead);
		List<lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";	
		}
	

	
	
	
}
