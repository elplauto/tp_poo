package fr.elplauto.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {

	@GetMapping("/address")
	public String showAddresses(Model model) {
		model.addAttribute("activePage","address");
		return "address";
	}

}

