package br.com.study.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
