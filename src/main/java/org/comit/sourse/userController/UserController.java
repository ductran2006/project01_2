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

	@RequestMapping("/listUsers")
	public String viewPage(Model model) {

		return listByPage(model, 1);
	}

	@RequestMapping("/pageNumber/{pageNumber}")
	public String listByPage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<User> page = service.listAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();

		List<User> listUsers = page.getContent();

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listUsers", listUsers);

		return "listUsers";
	}

	@RequestMapping("/createUser")
	public String showCreateUser(Model model) {
		System.out.println("Show user login");
		User user = new User();
		model.addAttribute("user", user);

		return "createUser";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
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
}
