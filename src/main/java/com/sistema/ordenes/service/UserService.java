package com.sistema.ordenes.service;

import com.sistema.ordenes.exception.ResourceNotFoundException;
import com.sistema.ordenes.model.User;
import com.sistema.ordenes.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepo;
    @Autowired
    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el usuario"));
    }

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public User update(Long id, User userUpdate) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario no encontado"));

        user.setName(userUpdate.getName());
        user.setLastname(userUpdate.getLastname());
        user.setEmail(userUpdate.getEmail());
        user.setTelephone(userUpdate.getTelephone());

        return this.userRepo.save(user);
    }

    @Override
    public String deleteById(Long id) {
        this.userRepo.deleteById(id);
        return "Eliminado";
    }

    public boolean exist(Long id){
        if(userRepo.existsById(id)){
            return true;
        }else {return false;}
    }
}
