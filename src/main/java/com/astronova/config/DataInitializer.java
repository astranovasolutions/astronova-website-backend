package com.astronova.config;

import com.astronova.role.entity.Role;
import com.astronova.role.enums.RoleType;
import com.astronova.role.repository.RoleRepository;
import com.astronova.user.entity.User;
import com.astronova.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        // Create all roles
        createRole(RoleType.ROLE_SUPER_ADMIN);
        createRole(RoleType.ROLE_ADMIN);
        createRole(RoleType.ROLE_EDITOR);
        createRole(RoleType.ROLE_VIEWER);

        Role superAdminRole =
                roleRepository.findByName(RoleType.ROLE_SUPER_ADMIN)
                        .orElseGet(() -> {

                            Role role = new Role();
                            role.setName(RoleType.ROLE_SUPER_ADMIN);

                            return roleRepository.save(role);
                        });

        if (!userRepository.existsByEmail("admin@astronova.com")) {

            User user = User.builder()
                    .firstName("Super")
                    .lastName("Admin")
                    .email("admin@astronova.com")
                    .password(
                            passwordEncoder.encode("Admin@123")
                    )
                    .enabled(true)
                    .role(superAdminRole)
                    .build();

            userRepository.save(user);

            System.out.println(
                    "SUPER ADMIN CREATED SUCCESSFULLY"
            );
        }
    }


    private void createRole(RoleType roleType) {

        roleRepository.findByName(roleType)
                .orElseGet(() -> {

                    Role role = new Role();
                    role.setName(roleType);

                    return roleRepository.save(role);
                });
    }

}