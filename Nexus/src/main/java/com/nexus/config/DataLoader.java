package com.nexus.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nexus.entity.Role;
import com.nexus.repository.RoleRepository;

@Configuration
public class RolesLoader {

    @Bean
    CommandLineRunner initDatabase(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                // 'ADMIN', 'USER', 'LANDLORD', 'GUEST
                roleRepository.save(new Role("GUEST"));
                roleRepository.save(new Role("ADMIN"));
                roleRepository.save(new Role("USER"));
                roleRepository.save(new Role("LANDLORD"));
            }
        };
    }
}
