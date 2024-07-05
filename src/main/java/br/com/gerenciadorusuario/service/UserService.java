package br.com.gerenciadorusuario.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciadorusuario.exceptions.ResourceNotFoundException;
import br.com.gerenciadorusuario.model.User;
import br.com.gerenciadorusuario.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User creatUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetalhes){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
        user.setNome(userDetalhes.getNome());
        user.setEmail(userDetalhes.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
        userRepository.delete(user);
    }
    
}
