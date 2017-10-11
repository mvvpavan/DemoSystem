package com.v3ops.controller;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.core.singletons.DisplayRepository;
import com.v3ops.Model.GroupNames;
import com.v3ops.Model.HostNames;
import com.v3ops.Model.Login;
import com.v3ops.Model.Register;
import com.v3ops.Repository.GroupNameRepo;
import com.v3ops.Repository.GroupNameSaveRepo;
import com.v3ops.Repository.HostSaveRepository;
import com.v3ops.Repository.RegisterRepo;

@Controller
public class HomeController {
	@Value("${svnurl}")
	String svnurl;
	@Value("${svnUserName}")
	String svnUserName;
	@Value("${svnPassword}")
	String svnPassword;
	@Autowired
	RegisterRepo registerRepo;
	@Autowired
	GroupNameRepo groupdao;
	@Autowired
	HostSaveRepository hostdao;
	@Autowired
	GroupNameSaveRepo groupsaverepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    final StaticLoggerBinder binder = StaticLoggerBinder.getSingleton();
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		LOGGER.info("Index Page");
		return "Login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signin(ModelMap model) {
		LOGGER.info("Login page");
		return "Login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(ModelMap model, HttpSession session) {

		session.setAttribute("username", "");

		return "index";
	}
	@RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
	public String Dashboard(ModelMap model, HttpSession session) {

		session.setAttribute("username", session.getAttribute("username"));
		return "DashBoard";
	}
	
	@RequestMapping(value = "/addgroup", method = RequestMethod.GET)
	public String addgroup(ModelMap model, HttpSession session) {

		session.setAttribute("username", session.getAttribute("username"));
		return "AddGroup";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap model, HttpSession session) {

		session.setAttribute("username", session.getAttribute("username"));
		return "RegisterUser";
	}
	@RequestMapping(value = "/addhost", method = RequestMethod.GET)
	public String addhost(ModelMap model, HttpSession session) {
		List<GroupNames> check = groupdao.findAll();
		model.addAttribute("grouplist", check);
		session.setAttribute("username", session.getAttribute("username"));
		return "AddIPS";
	}
	@RequestMapping(value = "/host", method = RequestMethod.POST)
	public String host(ModelMap model, @ModelAttribute("hostForm") @Validated HostNames hostname,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "AddIPS";
		}
		List<HostNames> list=hostdao.findByGroupnameAndHostname(hostname.getGroupname(), hostname.getHostname());
		
		if(list.size()==0)
		{
	    hostdao.save(hostname);
		model.addAttribute("message", "Success");
		}
		else
		{
			model.addAttribute("message", "hostname already existed with same group name");	
		}

		return "AddIPS";

	}
	@RequestMapping(value = "/rungroup", method = RequestMethod.GET)
	public String Groupserver(ModelMap model, HttpSession session) {
		List<GroupNames> check = groupdao.findAll();
		DisplayRepository dr;	
		dr = new DisplayRepository();
		dr.setupLibrary();
		List<String> result = dr.svrepository(svnurl, svnUserName, svnPassword);
		Map<String, String> repolists = new HashMap<String, String>();
		for (String re : result) {
			repolists.put(re, re);
		}
		// setupLibrary();
		model.addAttribute("grouplist", check);
		model.addAttribute("roleslist", repolists);
		session.setAttribute("username", session.getAttribute("username"));
		return "GroupServer";
	}
	@RequestMapping(value = "/group", method = RequestMethod.POST)
	public String Group(ModelMap model, @ModelAttribute("groupForm") @Validated GroupNames groupname,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "AddGroup";
		}
		List<GroupNames> list=groupsaverepo.findByGroupname(groupname.getGroupname());
		if(list.size()==0)
		{
		groupsaverepo.save(groupname);
		model.addAttribute("message", "Success");
		}
		else
		{
			model.addAttribute("message", "Group Name already available");
		}

		return "AddGroup";

	}
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String adduser(ModelMap model, @ModelAttribute("groupForm") @Validated Register register,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "RegisterUser";
		}
		List<Register> list=registerRepo.findByusername(register.getUsername());
		if(list.size()==0)
		{
			registerRepo.save(register);
		model.addAttribute("message", "Successfull Added user");
		}
		else
		{
			model.addAttribute("message", "Username already available");
		}

		return "RegisterUser";

	}
@RequestMapping(value = "/request", method = RequestMethod.POST)
public String login(ModelMap model, @ModelAttribute("loginForm") @Validated Login login, HttpSession session) {
	List<Register> loginResult=registerRepo.findByUsernameAndPassword(login.getUsername(),login.getPassword());
	if(loginResult.size()==0){
		model.put("result", "Invalid Username and Password");
		return"index";
	}
	else
	{
		session.setAttribute("username", login.getUsername());
		return"DashBoard";
	}
		
	
}


}