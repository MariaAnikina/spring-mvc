package maria.anikina.repository;

import maria.anikina.model.SupervisorEntity;

import java.util.Collection;

public interface SupervisorRepository {
	SupervisorEntity create(SupervisorEntity user);

	SupervisorEntity update(SupervisorEntity user);

	SupervisorEntity delete(Integer supervisorId);

	Collection<SupervisorEntity> getSupervisors();

	SupervisorEntity getSupervisorById(Integer id);
}
