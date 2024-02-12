package maria.anikina.repository;

import maria.anikina.model.EmployeeEntity;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository {
	EmployeeEntity create(EmployeeEntity user);

	EmployeeEntity update(EmployeeEntity user);

	EmployeeEntity delete(Integer id);

	Collection<EmployeeEntity> getEmployees();
	EmployeeEntity getEmployeeById(Integer id);
	List<EmployeeEntity> getEmployeesBySupervisorId(Integer supervisorId);
}
