package com.doohong.shoesfit;

import com.doohong.shoesfit.member.repository.MemberRoleRepository;
import com.doohong.shoesfit.member.domain.MemberRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class ShoesfitApplication {
    @Bean
    CommandLineRunner init(MemberRoleRepository memberRoleRepository) {
        System.out.println("init");
        return args -> {
            MemberRole adminRole = memberRoleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                MemberRole newAdminRole = MemberRole.builder().role("ADMIN").build();
                memberRoleRepository.save(newAdminRole);
                System.out.println(newAdminRole.toString());
            }

        };

    }
    public static void main(String[] args) {

        SpringApplication.run(ShoesfitApplication.class, args);
    }

}
