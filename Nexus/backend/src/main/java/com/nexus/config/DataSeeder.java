package com.nexus.config;
import com.nexus.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nexus.entity.Role;
import com.nexus.repository.RoleRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import com.nexus.repository.UserRepository;

import javax.sql.DataSource;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initRoles(UserRepository userRepository, RoleRepository roleRepository, DataSource dataSource, ResourceLoader resourceLoader) {
        return args -> {
            if (roleRepository.count() == 0) {
                // 'ADMIN', 'USER', 'LANDLORD'
                roleRepository.save(new Role("ADMIN"));
                roleRepository.save(new Role("USER"));
                roleRepository.save(new Role("LANDLORD"));
            }

            if (userRepository.count() < 30) {
                Resource resource = resourceLoader.getResource("classpath:userSeeders.sql");
                ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
            }
        };
    }
}
