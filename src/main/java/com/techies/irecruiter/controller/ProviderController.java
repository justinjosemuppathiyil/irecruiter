package main.java.com.techies.irecruiter.controller;


import java.util.List;

import javax.servlet.http.HttpSession;


import main.java.com.techies.irecruiter.service.ProviderService;
import main.java.com.techies.irecruiter.vo.LocationVO;
import main.java.com.techies.irecruiter.vo.ProviderVO;
import main.java.com.techies.irecruiter.vo.RequirmentQualificationVO;

import main.java.com.techies.irecruiter.vo.RequirmentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


	@Controller
	public class ProviderController {
		
		@Autowired
		ProviderService providerRegistrationService;
		
		String actionType;
		String page=null;
		@RequestMapping(value="/manageProviderDetails")//for create and update provider profile
		public String manageProviderDetails(@ModelAttribute("manageProviderDetailsForm")ProviderVO providerVO,ModelMap model,HttpSession session){
			
			System.out.println("reched providerRegistration");
			System.out.println("username:"+providerVO.getUsername());
			actionType = providerVO.getActionType();
			System.out.println("actionType: "+actionType);
			int providerId=0;
			 
			if("CREATE".equalsIgnoreCase(actionType)){
				 providerId=providerRegistrationService.createProvider(providerVO);
				actionType="CREATE";
				
				session.setAttribute("actionType", actionType);
				System.out.println("after createprovider controller");
				String status=null;
				
				if(providerId>0)
				{
					status="Profile updated successfully";
					model.addAttribute("providerId",providerId);
					model.addAttribute("providerVO",providerVO);
					page="providerhome";
				}
				else
				{
					status="error";
					model.addAttribute("status",status);
					page="manageproviderdetails";
				}
			
				
			}
				else if("UPDATE".equalsIgnoreCase(actionType)){
				
					providerRegistrationService.updateProviderProfile(providerVO);
					 providerId = providerVO.getProviderID();
					model.addAttribute("providerId",providerId);
					actionType="CREATE";
					session.setAttribute("actionType", actionType);
					model.addAttribute("providerVO",providerVO);
					page="providerhome";
				}
			session.setAttribute("providerId",providerId);
			return page;
			
			
		}
		
		@RequestMapping(value="/getProviderProfile")// for edit the provider profile
		public String getProviderProfile(@RequestParam("id")String id,ModelMap model,HttpSession session){
			
			System.out.println("Reached getProviderProfile and providerId: "+id);
			
			ProviderVO providerVO = providerRegistrationService.getProviderProfile(Integer.parseInt(id));
			model.addAttribute("providerVO",providerVO);
			System.out.println("ProviderId: "+providerVO.getProviderID()+" Username : "+providerVO.getUsername());
			String username = providerVO.getUsername();
			
			model.addAttribute("username",username);
			model.addAttribute("manageProviderDetailsForm",new ProviderVO());
			actionType="UPDATE";
			session.setAttribute("actionType", actionType);
			return "manageproviderdetails";
			
		}
		@RequestMapping(value="/viewProviderProfile")//for show only provider profile
		public String getProviderProfile(@RequestParam("id")String id,ModelMap model){
			ProviderVO providerVO = providerRegistrationService.getProviderProfile(Integer.parseInt(id));
			model.addAttribute("providerVO",providerVO);
			return "viewproviderprofile";

			
		}
		@RequestMapping(value="/addJobRequirments")//for link(Add Requirments)in Providerhome
		public String addJobRequirments(@RequestParam("id")String id,ModelMap model){
			int providerID = Integer.parseInt(id);
			model.addAttribute("providerID",providerID);
			model.addAttribute("AddRequirmentsForm",new RequirmentVO());
			
			return "addrequirments";

			
		}
		@RequestMapping(value="/submitRequirments",method=RequestMethod.GET)// for create and update job requirments
		public String addRequirments(@ModelAttribute("AddRequirmentsForm")RequirmentVO requirmentVO,ModelMap model,HttpSession session)
		{
			//model.addAttribute("requirmentVO",requirmentVO);
			//int requirmentID = requirmentVO.getRequirmentID();
			actionType = requirmentVO.getActionType();
			System.out.println("actionType: "+actionType);
			 
			if("CREATE".equalsIgnoreCase(actionType)){
				
				int requirmentID=providerRegistrationService.addRequirment(requirmentVO);
				actionType="CREATE";
				session.setAttribute("actionType", actionType);
				System.out.println("after addRequirment controller");
				model.addAttribute("RequirmentsLocationForm",new LocationVO() );
				System.out.println("requirmentID: "+requirmentID);
				int providerID=requirmentVO.getProviderID();
				System.out.println("providerID: "+providerID);
				model.addAttribute("providerID",providerID);
				model.addAttribute("requirmentID",requirmentID);
				page = "addrequirmentlocation";
			
			}
			else if("UPDATE".equalsIgnoreCase(actionType)){
				System.out.println("inside update requirment ");
				int providerID = (Integer) session.getAttribute("providerId");
				requirmentVO.setProviderID(providerID);
				providerRegistrationService.updateJobRequirment(requirmentVO);
				int requirmentID = requirmentVO.getRequirmentID();
				model.addAttribute("requirmentID",requirmentID);
				actionType="VIEW";
				session.setAttribute("actionType", actionType);
				model.addAttribute("RequirmentsLocationForm",new LocationVO());
				List<LocationVO> locationList = providerRegistrationService.getRequirmentLocation(requirmentID);
				model.addAttribute("locationList",locationList);
				page="addrequirmentlocation";
			}
			return page;
			
		}
		
		@RequestMapping(value="/submitRequirmentsLocation",method=RequestMethod.GET)// for create and update job requirments locations(repeating)
		public String addRequirmentLocation(@ModelAttribute("RequirmentsLocationForm")LocationVO locationVO,ModelMap model,HttpSession session)
		{
			System.out.println("actiontype:"+actionType);
			int requirmentID = locationVO.getRequirmentID();
			System.out.println("requirmentID:"+requirmentID);
			System.out.println("providerID:"+locationVO.getProviderID());
			if("CREATE".equalsIgnoreCase(actionType)){
			
			providerRegistrationService.addRequirmentLocation(locationVO);
			System.out.println("after reached add requirment location @ controller");
			actionType="CREATE";
			session.setAttribute("actionType", actionType);
			int providerID = locationVO.getProviderID();
			 session.setAttribute("providerId",providerID);
			 System.out.println("provider id:"+providerID);
			model.addAttribute("providerID",providerID);
			model.addAttribute("requirmentID",requirmentID);
			System.out.println("Requirmentid:"+requirmentID);
			model.addAttribute("RequirmentsLocationForm",new LocationVO());
			page = "addrequirmentlocation";
			}
			else if("UPDATE".equalsIgnoreCase(actionType)){
				System.out.println("inside update location and locationid "+locationVO.getLocationID());
				providerRegistrationService.updateRequirmentLocation(locationVO);
				actionType="VIEW";
				session.setAttribute("actionType", actionType);
				
				model.addAttribute("RequirmentsLocationForm",new LocationVO());
				List<LocationVO> locationList = providerRegistrationService.getRequirmentLocation(requirmentID);
				model.addAttribute("locationList",locationList);
				model.addAttribute("requirmentID",requirmentID);
				page="addrequirmentlocation";
			}
			return page;
			
		}
		@RequestMapping(value="/addRequirmentsLocation")//for go to next page(requirment qualification)
		public String addRequirmentsLocation(@RequestParam("id")String id,ModelMap model,HttpSession session){
			int requirmentID = Integer.parseInt(id);
			System.out.println("requirmentID: "+Integer.parseInt(id));
			int providerID = (Integer) session.getAttribute("providerId");
			System.out.println("providerID: "+providerID);
			model.addAttribute("providerID",providerID);
			model.addAttribute("requirmentID",requirmentID);
			model.addAttribute("RequirmentsQualificationForm",new RequirmentQualificationVO() );
			 if("VIEW".equalsIgnoreCase(actionType)){
				List<RequirmentQualificationVO> qualificationList = providerRegistrationService.getRequirmentQualification(requirmentID);
				model.addAttribute("qualificationList",qualificationList);
				model.addAttribute("RequirmentsQualificationForm",new RequirmentQualificationVO());
				 
			 }
			return "addrequirmentqualification";
	
		
		}
		@RequestMapping(value="/submitRequirmentsQualification",method=RequestMethod.GET)// for create and update job requirments qualifications(repeating)
		public String addRequirmentQualification(@ModelAttribute("RequirmentsQualificationForm")RequirmentQualificationVO requirmentQualificationVO,ModelMap model)
		{
			if("CREATE".equalsIgnoreCase(actionType)){
			//model.addAttribute("requirmentVO",requirmentVO);
			System.out.println("qualification: "+requirmentQualificationVO.getQualification());
			System.out.println("qualification: "+requirmentQualificationVO.getQualificationSpecilization());
			System.out.println("requirmentID: "+requirmentQualificationVO.getRequirmentID());
			
			providerRegistrationService.addRequirmentQualification(requirmentQualificationVO);
			int requirmentID = requirmentQualificationVO.getRequirmentID();
			int providerID = requirmentQualificationVO.getProviderID();
			model.addAttribute("requirmentID",requirmentID);
			model.addAttribute("providerID",providerID);
			model.addAttribute("RequirmentsQualificationForm",new RequirmentQualificationVO());
			page = "addrequirmentqualification";
		}
			else if("UPDATE".equalsIgnoreCase(actionType)){
				System.out.println("inside update qualification ");
				providerRegistrationService.updateRequirmentQualification(requirmentQualificationVO);
				int requirmentID = requirmentQualificationVO.getRequirmentID();
				int providerID = requirmentQualificationVO.getProviderID();
				model.addAttribute("requirmentID",requirmentID);
				model.addAttribute("providerID",providerID);
				List<RequirmentQualificationVO> qualificationList = providerRegistrationService.getRequirmentQualification(requirmentID);
				model.addAttribute("qualificationList",qualificationList);
				model.addAttribute("RequirmentsQualificationForm",new RequirmentQualificationVO());
				page = "addrequirmentqualification";
			}
			return page;
			
		}
		@RequestMapping(value="/addRequirmentsQualification")//for go to next page(view corresponding requirments details)
		public String addRequirmentsQualification(@RequestParam("id")String id,ModelMap model,HttpSession session){
			System.out.println("requirmentID: "+Integer.parseInt(id));
			int requirmentID = Integer.parseInt(id);
			int providerId =(Integer) session.getAttribute("providerId") ;
			RequirmentVO requirmentVO = providerRegistrationService.getJobRequirment(requirmentID,providerId);
			System.out.println("requirmentID: "+requirmentVO.getRequirmentID());
			System.out.println("jobtitile: "+requirmentVO.getJobTitle());
			model.addAttribute("requirmentVO",requirmentVO);
			List<String>  skillList = providerRegistrationService.getRequirmentSkill(requirmentID);
			model.addAttribute("skillList", skillList);
			session.setAttribute("skillList", skillList);
			List<LocationVO> locationList = providerRegistrationService.getRequirmentLocation(requirmentID);
			model.addAttribute("locationList",locationList);
			List<RequirmentQualificationVO> qualificationList = providerRegistrationService.getRequirmentQualification(requirmentID);
			model.addAttribute("qualificationList",qualificationList);
			
			model.addAttribute("RequirmentForm",new RequirmentVO() );
			return "viewjobrequirment";
		
		}
		@RequestMapping(value="/showRequirmentDetails")//after viewjob requirments then click finish 
		public String finish(@ModelAttribute("RequirmentForm")ProviderVO providerVO,ModelMap model,HttpSession session){
			
			if("VIEW".equalsIgnoreCase(actionType)){
				page="viewalljobrequirments";
			}
			else{
			
			int id =(Integer) session.getAttribute("providerId") ;
			System.out.println("after finish providerId:"+id);
			model.addAttribute("providerId",id);
			ProviderVO providerVO1 = providerRegistrationService.getProviderProfile(id);
			model.addAttribute("providerVO",providerVO1);
			page = "providerhome";
			}
			return page;
		}
		@RequestMapping(value="/getAllRequirmentDetails")//link(inbox)in providerhome
		public String getAllRequirmentDetails(@RequestParam("id")String id,ModelMap model,HttpSession session){
			
			System.out.println("Reached getAllRequirmentDetails and providerId: "+id);
			//RequirmentResultVO requirmentResultVO = providerRegistrationService.getAllRequirmentDetails(Integer.parseInt(id));
			List<RequirmentVO> requirmentList = providerRegistrationService.getJobRequirments(Integer.parseInt(id));
			session.setAttribute("requirmentList",requirmentList);
			return "viewalljobrequirments";
		}
		@RequestMapping(value="/viewRequirmentsDetails")//for view all requirmets details
		public String viewRequirmentsDetails(@RequestParam("id")String id,ModelMap model,HttpSession session){
			actionType="VIEW";
			session.setAttribute("actionType", actionType);
			System.out.println("Reached viewRequirmentsDetails actionType: "+actionType);
			System.out.println("Reached viewRequirmentsDetails and requirmentId: "+id);
			System.out.println("requirmentID: "+Integer.parseInt(id));
			int requirmentID = Integer.parseInt(id);
			int providerId =(Integer) session.getAttribute("providerId") ;
			RequirmentVO requirmentVO = providerRegistrationService.getJobRequirment(requirmentID,providerId);
			System.out.println("requirmentID: "+requirmentVO.getRequirmentID());
			System.out.println("jobtitile: "+requirmentVO.getJobTitle());
			model.addAttribute("requirmentVO",requirmentVO);
			List<String>  skillList = providerRegistrationService.getRequirmentSkill(requirmentID);
			model.addAttribute("skillList", skillList);
			session.setAttribute("skillList", skillList);
			List<LocationVO> locationList = providerRegistrationService.getRequirmentLocation(requirmentID);
			model.addAttribute("locationList",locationList);
			List<RequirmentQualificationVO> qualificationList = providerRegistrationService.getRequirmentQualification(requirmentID);
			model.addAttribute("qualificationList",qualificationList);
			//model.addAttribute("requirmentID",requirmentID);
			model.addAttribute("RequirmentForm",new RequirmentVO() );
			return "viewjobrequirment";
		}
		@RequestMapping(value="/editRequirmentDetails")//for edit the requirment 
		public String editRequirmentDetails(@RequestParam("id")String id,ModelMap model,HttpSession session){
			System.out.println("Reached viewRequirmentsDetails and requirmentId: "+id);
			int requirmentID = Integer.parseInt(id);
			int providerId =(Integer) session.getAttribute("providerId") ;
			RequirmentVO requirmentVO = providerRegistrationService.getJobRequirment(requirmentID,providerId);
			model.addAttribute("requirmentVO",requirmentVO);
			List<String>  skillList = providerRegistrationService.getRequirmentSkill(requirmentID);
			session.setAttribute("skillList", skillList);
			System.out.println(" after Reached viewRequirmentsDetails @ controller: ");
			model.addAttribute("AddRequirmentsForm",new RequirmentVO());
			actionType="UPDATE";
			System.out.println(" actiontype::"+actionType);
			session.setAttribute("actionType", actionType);
			return "addrequirments";
		
		}
		@RequestMapping(value="/editRequirmentsLocation")//for edit the requirment location
		public String editRequirmentsLocation(@RequestParam("id")String id,ModelMap model,HttpSession session){
			System.out.println("locationID: "+Integer.parseInt(id));
			int locationID = Integer.parseInt(id);
			
			LocationVO locationVO = providerRegistrationService.getJobLocation(locationID);
			model.addAttribute("locationVO",locationVO);
			model.addAttribute("RequirmentsLocationForm",new LocationVO() );
			actionType = "UPDATE";
			return "addrequirmentlocation";
		
		}
		@RequestMapping(value="/editRequirmentsqualification")//for edit the requirment qualification
		public String editRequirmentsqualification(@RequestParam("id")String id,ModelMap model,HttpSession session){
			System.out.println("qualificationID: "+Integer.parseInt(id));
			int qualificationID = Integer.parseInt(id);
			
			RequirmentQualificationVO requirmentQualificationVO = providerRegistrationService.getJobQualification(qualificationID);
			model.addAttribute("requirmentQualificationVO",requirmentQualificationVO);
			model.addAttribute("RequirmentsQualificationForm",new RequirmentQualificationVO() );
			actionType = "UPDATE";
			return "addrequirmentqualification";
		
		}
		@RequestMapping(value="/deleteRequirmentDetails")////for delete the requirments 
		public String deleteRequirmentDetails(@RequestParam("id")String id,ModelMap model,HttpSession session){
			
			providerRegistrationService.deleteRequirmentDetails(Integer.parseInt(id));
			String status = "Delete successfully...!!!";
			model.addAttribute("status",status);
			int providerID = (Integer) session.getAttribute("providerId");
			List<RequirmentVO> requirmentList = providerRegistrationService.getJobRequirments(providerID);
			session.setAttribute("requirmentList",requirmentList);
			return "viewalljobrequirments";

			
		}
		@RequestMapping(value="/providerHome")
		public String providerHome(ModelMap model,HttpSession session){
			int id= (Integer) session.getAttribute("providerId");
			ProviderVO providerVO = providerRegistrationService.getProviderProfile(id);
			model.addAttribute("providerVO",providerVO);
			return "providerhome";
		}
		@RequestMapping(value="/providerLogout")
		public String providerLogout(ModelMap model,HttpSession session){
			session.removeAttribute("providerId");
			session.invalidate();
			return "index";
		}

		
		

}
