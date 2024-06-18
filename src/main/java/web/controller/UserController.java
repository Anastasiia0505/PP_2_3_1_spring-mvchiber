package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String getAllShowUsers(Model model) {
		model.addAttribute("allUsers", userService.allUsers());
		return "allUsers";
	}

	@PostMapping("/search")
	public String searchUserId(@RequestParam int id, Model model) {
		User user = userService.getUserId(id);
		model.addAttribute("user", user);
		return "showUserId";
	}

	@GetMapping("/addUser")
	public String newPerson(@ModelAttribute("user") User user) {
		return "addUser";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/";
	}

	@GetMapping("/editUser")
	public String editUserForm(ModelMap model, @RequestParam("id") int id) {
		model.addAttribute("user", userService.getUserId(id));
		return "edit";
	}

	@PostMapping("/editUser")
	public String editUser(@ModelAttribute("user") User user,
						   BindingResult bindingResult, @RequestParam("id") int id) {
		if (bindingResult.hasErrors()) {
			return "edit";

		}
		userService.updateUser(id, user);
		return "redirect:/";
	}

	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") int id) {
		userService.deleteUser(id);
		return "redirect:/";
	}
}
