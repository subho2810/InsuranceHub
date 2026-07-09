package com.insurancehub.identity.config.startup;

import com.insurancehub.identity.entity.Role;
import com.insurancehub.identity.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleDataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {

        if (roleRepository.count() > 0) {
            return;
        }

        List<Role> roles = List.of(
                Role.builder().name("CUSTOMER").description("Insurance Customer").build(),
                Role.builder().name("AGENT").description("Insurance Agent").build(),
                Role.builder().name("BRANCH_MANAGER").description("Branch Manager").build(),
                Role.builder().name("CLAIMS_OFFICER").description("Claims Officer").build(),
                Role.builder().name("UNDERWRITER").description("Insurance Underwriter").build(),
                Role.builder().name("ADMIN").description("System Administrator").build()
        );

        roleRepository.saveAll(roles);

        System.out.println("Default roles initialized successfully.");
    }
}