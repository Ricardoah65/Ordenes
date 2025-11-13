package com.sistema.ordenes.service;

import com.sistema.ordenes.model.User;

import java.util.List;

public interface IUserService {
    public void saveUser(User user);
    public User findById(Long id);
    public List<User> findAll();
    public User update(Long id, User user);
    public String deleteById(Long id);
    public User findByEmail(String email);
}
