package com.emirovschi.midps3.users;

import com.emirovschi.midps3.users.models.UserModel;

import java.util.Optional;

public interface UserService
{
    Optional<UserModel> getUserByEmail(String email);

    void save(UserModel user);

    Optional<UserModel> getSessionUser();
}
