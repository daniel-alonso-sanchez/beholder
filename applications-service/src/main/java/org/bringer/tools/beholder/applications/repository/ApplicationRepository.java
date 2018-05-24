package org.bringer.tools.beholder.applications.repository;
import java.util.List;
import java.util.UUID;

import org.bringer.tools.beholder.applications.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository  extends JpaRepository<Application, UUID> {
	List<Application> findByName(String name);
}
