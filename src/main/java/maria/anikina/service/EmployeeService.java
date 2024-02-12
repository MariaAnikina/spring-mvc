package maria.anikina.service;

import maria.anikina.model.EmployeeEntity;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
	EmployeeEntity create(EmployeeEntity employee, Integer supervisorId);

	EmployeeEntity update(EmployeeEntity employee);

	EmployeeEntity delete(Integer id);

	EmployeeEntity getEmployeeById(Integer id);

	Collection<EmployeeEntity> getEmployees();

	List<EmployeeEntity> getEmployeesBySupervisorId(Integer supervisorId);
}
