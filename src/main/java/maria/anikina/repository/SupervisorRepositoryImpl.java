package maria.anikina.repository;


import lombok.extern.slf4j.Slf4j;
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

	@Override
	public SupervisorEntity create(SupervisorEntity supervisor) {
		supervisor.setId(idLast);
		idLast++;
		SupervisorEntity supervisorEntity = supervisors.put(supervisor.getId(), supervisor);
		log.info("Создан руководитель с id = " + supervisor.getId());
		return supervisorEntity;
	}

	@Override
	public SupervisorEntity update(SupervisorEntity supervisor) {
		SupervisorEntity supervisorEntity = supervisors.put(supervisor.getId(), supervisor);
		log.info("Обновлен руководитель с id = " + supervisor.getId());
		return supervisorEntity;
	}

	@Override
	public SupervisorEntity delete(Integer supervisorId) {
		SupervisorEntity supervisorEntity = supervisors.remove(supervisorId);
		log.info("Удален руководитель с id = " + supervisorId);
		return supervisorEntity;
	}

	@Override
	public Collection<SupervisorEntity> getSupervisors() {
		Collection<SupervisorEntity> supervisorEntities = supervisors.values();
		log.info("Получены все руководители");
		return supervisorEntities;
	}

	@Override
	public SupervisorEntity getSupervisorById(Integer id) {
		SupervisorEntity supervisor = supervisors.get(id);
		log.info("Получен руководитель по id = " + id);
		return supervisor;
	}

}
