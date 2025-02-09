package com.spring.security;

import com.spring.security.persistence.entities.Permisos;
import com.spring.security.persistence.entities.Role;
import com.spring.security.persistence.entities.RoleEnum;
import com.spring.security.persistence.entities.User;
import com.spring.security.persistence.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepo userRepo){
        return args -> {
            /* Create PERMISSIONS */
            Permisos createPermission = Permisos.builder()
                    .name("CREATE")
                    .build();

            Permisos readPermission = Permisos.builder()
                    .name("READ")
                    .build();

            Permisos updatePermission = Permisos.builder()
                    .name("UPDATE")
                    .build();

            Permisos deletePermission = Permisos.builder()
                    .name("DELETE")
                    .build();

            Permisos refactorPermission = Permisos.builder()
                    .name("REFACTOR")
                    .build();

            /* Create ROLES */
            Role roleAdmin = Role.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
                    .build();

            Role roleUser = Role.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissionList(Set.of(createPermission, readPermission))
                    .build();

            Role roleInvited = Role.builder()
                    .roleEnum(RoleEnum.INVITED)
                    .permissionList(Set.of(readPermission))
                    .build();

            Role roleDeveloper = Role.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
                    .build();

            /* CREATE USERS */
            User userSantiago = User.builder()
                    .username("santiago")
                    .password("1234")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            User userDaniel = User.builder()
                    .username("daniel")
                    .password("1234")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleUser))
                    .build();

            User userAndrea = User.builder()
                    .username("andrea")
                    .password("1234")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleInvited))
                    .build();

            User userAnyi = User.builder()
                    .username("anyi")
                    .password("1234")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();
            userRepo.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAnyi));
        };
    }
}
