package fr.elplauto.tp5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.elplauto.tp5.model.AddressRepository;

@Controller
public class AddressesController {
	@Autowired
	AddressRepository addressRepository;

	@GetMapping("/addresses")
	public String showAddresses(Model model) {
		model.addAttribute("allAddresses", addressRepository.findAll());
		model.addAttribute("activePage","addresses");
		return "addresses";
	}

}
