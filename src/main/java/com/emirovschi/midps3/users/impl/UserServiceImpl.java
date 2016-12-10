package com.emirovschi.midps3.users.impl;

import com.emirovschi.midps3.users.models.UserModel;
import com.emirovschi.midps3.users.UserRepository;
import com.emirovschi.midps3.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserModel> getUserByEmail(final String email)
    {
        return ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public void save(final UserModel user)
    {
        userRepository.save(user);
    }
}
