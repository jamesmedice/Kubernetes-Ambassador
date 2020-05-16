package com.medici.app.storage.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * 
 * @author a73s
 *
 */
@Configuration
@EnableRedisRepositories
@ComponentScan("com.medici.app.storage")
public class RepositoryConfig {

}
