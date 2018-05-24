package org.bringer.tools.beholder.applications.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"org.bringer.tools.beholder.applications.repository"})
@EntityScan(basePackages = "org.bringer.tools.beholder.applications.model")
@EnableTransactionManagement
public class JpaConfig {

}
