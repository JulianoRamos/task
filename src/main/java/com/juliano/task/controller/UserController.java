package com.juliano.task.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliano.task.model.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Validated()
public class UserController {

    @GetMapping("/{id}")
    public void getUser(@PathVariable("id") Long id) {
        // Lógica para obter um usuário pelo ID
    }

    @PostMapping
    public void createUser(@Valid @RequestBody User user) {
        // Lógica para criar um novo usuário
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        // Lógica para atualizar um usuário existente
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        // Lógica para excluir um usuário pelo ID
    }
}
