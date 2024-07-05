package br.com.gerenciadorusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciadorusuario.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
