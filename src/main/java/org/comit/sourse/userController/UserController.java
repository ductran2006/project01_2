package org.comit.sourse.userController;

import java.util.List;

import org.comit.sourse.bean.User;
import org.comit.sourse.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@RequestMapping("/createUser")
	public String showCreateUser(Model model) {
		System.out.println("Show user login");
		User user = new User();
		model.addAttribute("user",user);
		
		return "createUser";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		service.save(user);
		
		return "redirect:/";
	}
	
	@RequestMapping("/updateUser/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("updateUser");
	    User user = service.get(id);
	    mav.addObject("user", user);
	     
	    return mav;
	}
	
	@RequestMapping("/staffLogin")
	public String showStaffLogin() {
		System.out.println("Show staff login");
		return "staffLogin";
	}

	@RequestMapping("/userLogin")
	public String showUserLogin() {
		System.out.println("Show user login");
		return "userLogin";
	}

	@RequestMapping("/userScreen")
	public String showUserScreen() {
		System.out.println("Show user login");
		return "userScreen";
	}

	@RequestMapping("/listUsers")
	public String showListUsers(Model model, @Param("keyword") String keyword) {
		System.out.println("Show user login");
		List<User> listUsers = service.ListAll(keyword);
		model.addAttribute("listUsers", listUsers);

		return "listUsers";
	}

}

/*
 * @RequestMapping("/") public String viewHomePage(Model model) { return
 * viewPage(model, 1, "firstname", "abc"); }
 * 
 * @RequestMapping("/page/{pageNum}") public String viewPage(Model
 * model, @PathVariable(name = "pageNum") int pageNum,
 * 
 * @Param("sortField") String sortField, @Param("sortDir") String sortDir) {
 * 
 * Page<User> page = service.listAll(pageNum, sortField, sortDir);
 * 
 * List<User> listUsers = page.getContent();
 * 
 * model.addAttribute("currentPage", pageNum); model.addAttribute("totalPages",
 * page.getTotalPages()); model.addAttribute("totalItems",
 * page.getTotalElements());
 * 
 * model.addAttribute("sortField", sortField); model.addAttribute("sortDir",
 * sortDir); model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc"
 * : "asc");
 * 
 * model.addAttribute("listProducts", listUsers);
 * 
 * return "index"; }
 * 
 * 
 * @RequestMapping("/new") public String showNewUserForm(Model model) { User
 * user = new User(); model.addAttribute("user", user);
 * 
 * return "user"; }
 * 
 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
 * saveUser(@ModelAttribute("product") User user) { service.save(user);
 * 
 * return "redirect:/"; }
 * 
 * @RequestMapping("/edit/{id}") public ModelAndView
 * showEditUserForm(@PathVariable(name = "id") Integer id) { ModelAndView mav =
 * new ModelAndView("edit_user");
 * 
 * User user = service.get(id); mav.addObject("user", user);
 * 
 * return mav; }
 * 
 * @RequestMapping("/delete/{id}") public String deleteUser(@PathVariable(name =
 * "id") Integer id) { service.delete(id);
 * 
 * return "redirect:/"; } }
 */
