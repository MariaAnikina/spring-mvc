package maria.anikina.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maria.anikina.exception.PersonNotFoundException;
import maria.anikina.model.EmployeeEntity;
import maria.anikina.model.SupervisorEntity;
import maria.anikina.repository.EmployeeRepository;
import maria.anikina.repository.SupervisorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class SupervisorServiceImpl implements SupervisorService {
	private SupervisorRepository repository;
	private EmployeeRepository employeeRepository;

	@Override
	public SupervisorEntity create(SupervisorEntity supervisor) {
		return repository.create(supervisor);
	}

	@Override
	public SupervisorEntity update(SupervisorEntity supervisor) {
		return repository.update(supervisor);
	}

	@Override
	public SupervisorEntity delete(Integer id) {
		validationFindEmployee(id);
		List<EmployeeEntity> employeesBySupervisorId = employeeRepository.getEmployeesBySupervisorId(id);
		for (EmployeeEntity employee : employeesBySupervisorId) {
			employee.setSupervisorId(-1);
		}
		return repository.delete(id);
	}

	@Override
	public SupervisorEntity getSupervisorById(Integer id) {
		validationFindEmployee(id);
		return repository.getSupervisorById(id);
	}

	@Override
	public Collection<SupervisorEntity> getSupervisors() {
		return repository.getSupervisors();
	}

	private void validationFindEmployee(Integer id) {
		if (repository.getSupervisorById(id) == null) {
			log.warn("Не найден руководитель с id = " + id);
			throw new PersonNotFoundException("Не найден руководитель с id = " + id);
		}
	}
}
