package main.java.com.techies.irecruiter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import main.java.com.techies.irecruiter.service.AdministratorService;
import main.java.com.techies.irecruiter.vo.ProviderVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministratorController {
	@Autowired
	AdministratorService administratorService;
	
	
	@RequestMapping(value="/deleteProviderProfile")
	public String deleteProviderProfile(@RequestParam("id")String id,ModelMap model,HttpSession session){
		
		administratorService.deleteProviderProfile(Integer.parseInt(id));
		String status = "Block successfully...!!!";
		model.addAttribute("status",status);
		List<ProviderVO> allProviderList = administratorService.getAllProviderDeatils();
		session.setAttribute("allProviderList",allProviderList);
		model.addAttribute("adminForm",new ProviderVO());
		
		return "adminhome";

		
	}
	@RequestMapping(value="/viewAllProviderProfile")
	public String getAllProviderProfile(@RequestParam("id")String id,ModelMap model){
		
		ProviderVO providerVO = administratorService.getProviderProfile(Integer.parseInt(id));
		model.addAttribute("providerVO",providerVO);
		return "viewproviderprofile";

		
	}
	@RequestMapping(value="/adminHome")
	public String providerHome(ModelMap model){
		model.addAttribute("adminForm",new ProviderVO());
		return "adminhome";
	}
	@RequestMapping(value="/adminLogout")
	public String providerLogout(ModelMap model){
		return "index";
	}
	

}
