package com.emirovschi.midps3.users;

import com.emirovschi.midps3.images.dto.ImageDTO;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.exceptions.UserAlreadyExistsException;

public interface UserFacade
{
    UserDTO getSessionUser();

    ImageDTO getAvatar(long id);

    void register(UserDTO user) throws UserAlreadyExistsException;
}
