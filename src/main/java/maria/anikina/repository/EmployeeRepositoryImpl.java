package maria.anikina.repository;

import lombok.extern.slf4j.Slf4j;
import maria.anikina.logging.Logging;
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

	@Logging
	@Override
	public EmployeeEntity create(EmployeeEntity employee) {
		employee.setId(idLast);
		idLast++;
		EmployeeEntity employeeEntity = employees.put(employee.getId(), employee);
		return employeeEntity;
	}

	@Logging
	@Override
	public EmployeeEntity update(EmployeeEntity employee) {
		EmployeeEntity employeeEntity = employees.put(employee.getId(), employee);
		return employeeEntity;
	}

	@Logging
	@Override
	public EmployeeEntity delete(Integer id) {
		EmployeeEntity employeeEntity = employees.remove(id);
		return employeeEntity;
	}

	@Logging
	@Override
	public Collection<EmployeeEntity> getEmployees() {
		Collection<EmployeeEntity> employeeEntities = employees.values();
		return employeeEntities;
	}

	@Logging
	@Override
	public EmployeeEntity getEmployeeById(Integer id) {
		EmployeeEntity employeeEntity = employees.get(id);
		return employeeEntity;
	}

	@Logging
	@Override
	public List<EmployeeEntity> getEmployeesBySupervisorId(Integer supervisorId) {
		List<EmployeeEntity> employeesBySupervisorId = employees.values().stream()
				.filter(employee -> employee.getSupervisorId() == supervisorId)
				.collect(Collectors.toList());
		return employeesBySupervisorId;
	}
}
