package maria.anikina.controller;


import lombok.AllArgsConstructor;
import maria.anikina.model.EmployeeEntity;
import maria.anikina.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService service;

	@GetMapping
	public String getEmployees(Model model) {
		model.addAttribute("employees", service.getEmployees());
		return "employees";
	}

	@GetMapping("/add/{supervisorId}")
	public String addEmployee(@PathVariable int supervisorId, Model model) {
		EmployeeEntity employee = new EmployeeEntity();
		model.addAttribute("employee", employee);
		return "add-employee";
	}

	@PostMapping("/createEmployee/{supervisorId}")
	public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeEntity employee,
	                           BindingResult bindingResult,
	                           @PathVariable int supervisorId) {
		if (bindingResult.hasErrors()) {
			return "add-employee";
		}
		service.create(employee, supervisorId);
		return "redirect:/supervisor/" + supervisorId;
	}


	@GetMapping("/employees/{supervisorId}")
	public String getEmployeesBySupervisorId(@PathVariable int supervisorId, Model model) {
		Collection<EmployeeEntity> employees = service.getEmployeesBySupervisorId(supervisorId);
		model.addAttribute("employees", employees);
		return "employees-supervisorId";
	}

	@GetMapping("/{id}")
	public String getEmployeeById(@PathVariable int id, Model model) {
		EmployeeEntity employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employees-id";
	}

	@GetMapping("/update/{id}")
	public String updateEmployee(@PathVariable int id, Model model) {
		EmployeeEntity employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update-employee";
	}

	@PostMapping("/updateEmployee/{id}")
	public String updateEmployeeById(@Valid @ModelAttribute("employee") EmployeeEntity employee,
	                                 BindingResult bindingResult,
	                                 @PathVariable int id) {
		if (bindingResult.hasErrors()) {
			return "update-employee";
		}
		employee.setId(id);
		service.update(employee);
		return "redirect:/employee";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id, Model model) {
		EmployeeEntity employee = service.delete(id);
		model.addAttribute("employee", employee);
		return "redirect:/supervisor";
	}
}
