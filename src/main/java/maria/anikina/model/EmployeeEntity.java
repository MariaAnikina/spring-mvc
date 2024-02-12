package maria.anikina.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Component
@Getter
@Setter
public class EmployeeEntity {
	private int id;
	@NotBlank(message = "Безликих не нанимаем")
	@Size(min = 3, message = "Слишком короткое ФИО")
	private String fullName;
	private JobTitle position = JobTitle.SUBORDINATE;
	@Min(value = 20000, message = "На что жить сотруднику!? Увеличьте зарплату")
	private int salary;
	private int supervisorId;
}
