package me.youdontfind.config;

import me.youdontfind.repositories.common.impl.CustomRevisionRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = "me.youdontfind.repositories", repositoryBaseClass = CustomRevisionRepositoryImpl.class)
public class RepositoryConfig {
}