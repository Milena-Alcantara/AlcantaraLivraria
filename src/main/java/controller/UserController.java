package controller;

import model.UserModel;
import repository.UserRepository;

public class UserController {
    UserRepository userRepository = new UserRepository();
    UserModel userModel = new UserModel();

    public boolean register(String nome, String cpf, String email, String senha) {
        userModel.setName(nome);
        userModel.setCpf(cpf);
        userModel.setEmail(email);
        userModel.setPassword(senha);
        return userRepository.registerUser(userModel.getName(), userModel.getCpf(), userModel.getEmail(), userModel.getPassword());
    }

    public Boolean logIn(String email, String password) {
        userModel.setEmail(email);
        userModel.setPassword(password);
        return userRepository.logIn(userModel.getEmail(), userModel.getPassword());
    }
}
