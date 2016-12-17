package com.emirovschi.midps3.users;

import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.exceptions.UserAlreadyExistsException;

public interface UserFacade
{
    UserDTO getSessionUser();

    void register(UserDTO user) throws UserAlreadyExistsException;
}
