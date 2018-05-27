package com.emirovschi.midps3.users;

import com.emirovschi.midps3.medias.dto.MediaDTO;
import com.emirovschi.midps3.users.dto.UpdateUserDTO;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.exceptions.UserAlreadyExistsException;

public interface UserFacade
{
    UserDTO getSessionUser();

    MediaDTO getAvatar(long id);

    void register(UserDTO user) throws UserAlreadyExistsException;

    void update(UpdateUserDTO user);
}
