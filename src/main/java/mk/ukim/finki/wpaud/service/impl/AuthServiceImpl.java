package mk.ukim.finki.wpaud.service.impl;

import mk.ukim.finki.wpaud.model.User;
import mk.ukim.finki.wpaud.repository.InMemoryUserRepository;
import mk.ukim.finki.wpaud.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final InMemoryUserRepository inMemoryUserRepository;

    public AuthServiceImpl(InMemoryUserRepository inMemoryUserRepository) {
        this.inMemoryUserRepository = inMemoryUserRepository;
    }
    @Override
    public User login(String username, String password) {
        if (username==null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return inMemoryUserRepository.findByUsernameAndPassword(username, password).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!password.equals(repeatPassword)) {
            throw new IllegalArgumentException();
        }
        User user = new User(username,password,name, surname);
        return inMemoryUserRepository.saveOrUpdate(user);
    }
}
