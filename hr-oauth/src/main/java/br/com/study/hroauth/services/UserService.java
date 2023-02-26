package br.com.study.hroauth.services;

import org.springframework.stereotype.Service;

import br.com.study.hroauth.entities.User;
import br.com.study.hroauth.feignclients.UserFeignClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    @NonNull
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        if (userFeignClient.findByEmail(email).getBody() == null) {
            throw new IllegalArgumentException("Email not found!");
        }
        log.info("Email: " + email + " found!");
        return userFeignClient.findByEmail(email).getBody();
    }
}
