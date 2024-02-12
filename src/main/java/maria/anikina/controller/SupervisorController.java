package maria.anikina.controller;


import lombok.AllArgsConstructor;
import maria.anikina.model.SupervisorEntity;
import maria.anikina.service.SupervisorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/supervisor")
public class SupervisorController {
	private final SupervisorService service;

	@GetMapping
	public String showPageSupervisors(Model model) {
		model.addAttribute("supervisors", service.getSupervisors());
		return "supervisors";
	}

	@GetMapping("/{id}")
	public String getById(@PathVariable Integer id, Model model) {
		model.addAttribute("supervisor", service.getSupervisorById(id));
		return "supervisor-id";
	}

	@PostMapping("/createSupervisor")
	public String saveSupervisor(@Valid @ModelAttribute("supervisor") SupervisorEntity supervisor,
	                             BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-supervisor";
		}
		service.create(supervisor);
		return "redirect:/supervisor";
	}

	@GetMapping("/add")
	public String addSupervisor(Model model) {
		model.addAttribute("supervisor", new SupervisorEntity());
		return "add-supervisor";
	}


	@GetMapping("/update/{id}")
	public String updateSupervisor(@PathVariable int id, Model model) {
		SupervisorEntity supervisor = service.getSupervisorById(id);
		model.addAttribute("supervisor", supervisor);
		return "update-supervisor";
	}

	@PostMapping("/updateSupervisor/{id}")
	public String updateSupervisor(@Valid @ModelAttribute("supervisor") SupervisorEntity supervisor,
	                               BindingResult bindingResult,
	                               @PathVariable int id) {
		if (bindingResult.hasErrors()) {
			return "update-supervisor";
		}
		supervisor.setId(id);
		service.update(supervisor);
		return "redirect:/supervisor";
	}

	@GetMapping("/delete/{id}")
	public String deleteSupervisor(@PathVariable int id, Model model) {
		SupervisorEntity supervisor = service.delete(id);
		model.addAttribute("supervisor", supervisor);
		return "redirect:/supervisor";
	}
}
