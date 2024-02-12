package maria.anikina.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class SupervisorEntity {
	private int id;
	@NotBlank(message = "Безликих не нанимаем")
	@Size(min = 3, message = "Слишком короткое ФИО")
	private String fullName;
	private JobTitle position = JobTitle.BOSS;
	private String category;
	@Max(value = 500000, message = "Может лучше не нанимать?)")
	private int salary;
	private List<EmployeeEntity> subordinates = new ArrayList<>();

}
