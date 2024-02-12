package maria.anikina.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maria.anikina.exception.PersonNotFoundException;
import maria.anikina.model.EmployeeEntity;
import maria.anikina.repository.EmployeeRepository;
import maria.anikina.repository.SupervisorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository repository;
	private SupervisorRepository supervisorRepository;

	@Override
	public EmployeeEntity create(EmployeeEntity employee, Integer supervisorId) {
		supervisorRepository.getSupervisorById(supervisorId).getSubordinates().add(employee);
		return repository.create(employee);
	}

	@Override
	public EmployeeEntity update(EmployeeEntity employee) {
		return repository.update(employee);
	}

	@Override
	public EmployeeEntity delete(Integer id) {
		validationFindEmployee(id);
		return repository.delete(id);
	}

	@Override
	public EmployeeEntity getEmployeeById(Integer id) {
		validationFindEmployee(id);
		return repository.getEmployeeById(id);
	}

	@Override
	public Collection<EmployeeEntity> getEmployees() {
		return repository.getEmployees();
	}

	@Override
	public List<EmployeeEntity> getEmployeesBySupervisorId(Integer supervisorId) {
		validationFindEmployee(supervisorId);
		return repository.getEmployeesBySupervisorId(supervisorId);
	}

	private void validationFindEmployee(Integer id) {
		if (repository.getEmployeeById(id) == null) {
			log.warn("Не найден сотрудник с id = " + id);
			throw new PersonNotFoundException("Не найден сотрудник с id = " + id);
		}
	}
}
