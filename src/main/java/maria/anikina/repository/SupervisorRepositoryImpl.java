package maria.anikina.repository;


import lombok.extern.slf4j.Slf4j;
import maria.anikina.logging.Logging;
import maria.anikina.model.SupervisorEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class SupervisorRepositoryImpl implements SupervisorRepository {
	private Map<Integer, SupervisorEntity> supervisors = new HashMap<>();
	private int idLast = 1;

	@Logging
	@Override
	public SupervisorEntity create(SupervisorEntity supervisor) {
		supervisor.setId(idLast);
		idLast++;
		SupervisorEntity supervisorEntity = supervisors.put(supervisor.getId(), supervisor);
		return supervisorEntity;
	}

	@Logging
	@Override
	public SupervisorEntity update(SupervisorEntity supervisor) {
		SupervisorEntity supervisorEntity = supervisors.put(supervisor.getId(), supervisor);
		return supervisorEntity;
	}

	@Logging
	@Override
	public SupervisorEntity delete(Integer supervisorId) {
		SupervisorEntity supervisorEntity = supervisors.remove(supervisorId);
		return supervisorEntity;
	}

	@Logging
	@Override
	public Collection<SupervisorEntity> getSupervisors() {
		Collection<SupervisorEntity> supervisorEntities = supervisors.values();
		return supervisorEntities;
	}

	@Logging
	@Override
	public SupervisorEntity getSupervisorById(Integer id) {
		SupervisorEntity supervisor = supervisors.get(id);
		return supervisor;
	}

}
