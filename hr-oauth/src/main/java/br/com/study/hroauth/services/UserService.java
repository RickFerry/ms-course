package br.com.study.hroauth.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.study.hroauth.entities.User;
import br.com.study.hroauth.feignclients.UserFeignClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    @NonNull
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        if (userFeignClient.findByEmail(email).getBody() == null) {
            throw new IllegalArgumentException("Email not found!");
        }
        log.info("Email: " + email + " found!");
        return userFeignClient.findByEmail(email).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (userFeignClient.findByEmail(userName).getBody() == null) {
            throw new UsernameNotFoundException("Email not found!");
        }
        log.info("Email: " + userName + " found!");
        return userFeignClient.findByEmail(userName).getBody();
    }
}
