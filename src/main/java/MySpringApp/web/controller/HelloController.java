package MySpringApp.web.controller;

import MySpringApp.models.User;
import MySpringApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


	private final UserService userService;

	@Autowired
	public HelloController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String printWelcome(Model model) {
		List<String> messages = new ArrayList<>();

		messages.add("Hello! To display all users click:");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/users")
	public String showAllUsers(Model model) {
		List<User> userList = userService.getAllUsers();
		model.addAttribute("userList", userList);
		return "users";
	}

	@GetMapping("/users/{id}")
	public String showUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "showUser";
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.removeUserById(id);
		return "redirect:/users";
	}

	@GetMapping("users/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping("users")
	public String create(@ModelAttribute("user") User user) {
		userService.addUser(user.getName(), user.getLastName(), user.getAge());
		return "redirect:/users";
	}

	@GetMapping("users/{id}/edit")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit";
	}

	@PatchMapping("users/{id}")
	public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
		userService.updateUser(id, user.getName(), user.getLastName(), user.getAge());
		return "redirect:/users";
	}
}

