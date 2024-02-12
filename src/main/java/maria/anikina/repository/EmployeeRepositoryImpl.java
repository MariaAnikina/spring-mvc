package maria.anikina.repository;

import lombok.extern.slf4j.Slf4j;
import maria.anikina.model.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
	private Map<Integer, EmployeeEntity> employees = new HashMap<>();
	private int idLast = 1;

	public EmployeeEntity create(EmployeeEntity employee) {
		employee.setId(idLast);
		idLast++;
		EmployeeEntity employeeEntity = employees.put(employee.getId(), employee);
		log.info("Создан руководитель по id = " + employee.getId());
		return employeeEntity;
	}

	@Override
	public EmployeeEntity update(EmployeeEntity employee) {
		EmployeeEntity employeeEntity = employees.put(employee.getId(), employee);
		log.info("Обновлен руководитель по id = " + employee.getId());
		return employeeEntity;
	}

	@Override
	public EmployeeEntity delete(Integer id) {
		EmployeeEntity employeeEntity = employees.remove(id);
		log.info("Удален руководитель по id = " + id);
		return employeeEntity;
	}

	@Override
	public Collection<EmployeeEntity> getEmployees() {
		Collection<EmployeeEntity> employeeEntities = employees.values();
		log.info("Получены все сотрудники");
		return employeeEntities;
	}

	@Override
	public EmployeeEntity getEmployeeById(Integer id) {
		EmployeeEntity employeeEntity = employees.get(id);
		log.info("Получен сотрудник с id = " + id);
		return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> getEmployeesBySupervisorId(Integer supervisorId) {
		List<EmployeeEntity> employeesBySupervisorId = employees.values().stream()
				.filter(employee -> employee.getSupervisorId() == supervisorId)
				.collect(Collectors.toList());
		log.info("Получены сотрудники руководителя с id = " + supervisorId);
		return employeesBySupervisorId;
	}
}
