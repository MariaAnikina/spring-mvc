package maria.anikina.service;

import maria.anikina.model.SupervisorEntity;

import java.util.Collection;

public interface SupervisorService {
	SupervisorEntity create(SupervisorEntity supervisor);

	SupervisorEntity update(SupervisorEntity supervisor);

	SupervisorEntity delete(Integer supervisorId);

	SupervisorEntity getSupervisorById(Integer id);

	Collection<SupervisorEntity> getSupervisors();
}
