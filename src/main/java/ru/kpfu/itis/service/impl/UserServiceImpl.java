package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.UserModifyForm;
import ru.kpfu.itis.form.UserRegistrationForm;
import ru.kpfu.itis.message.SendMail;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.util.transform.UserModifyFormTransform;
import ru.kpfu.itis.util.transform.UserRegistrationFormToUserTransformer;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserRegistrationForm form) {
        User user = UserRegistrationFormToUserTransformer.transform(form);
        userRepository.save(user);
    }

    @Secured("hasRole('ROLE_ADMIN')")
    @Override
    public void securedMethod() {
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void modifyUser(UserModifyForm form) {
        User user = UserModifyFormTransform.transform(form);
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }


}
