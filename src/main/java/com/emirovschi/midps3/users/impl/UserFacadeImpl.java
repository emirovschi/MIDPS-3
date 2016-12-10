package com.emirovschi.midps3.users.impl;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.UserFacade;
import com.emirovschi.midps3.users.models.UserModel;
import com.emirovschi.midps3.users.UserService;
import com.emirovschi.midps3.users.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade
{
    @Autowired
    private UserService userService;

    @Autowired
    private Converter<UserDTO, UserModel> userReverseConverter;

    @Override
    public void register(final UserDTO user) throws UserAlreadyExistsException
    {
        if (userService.getUserByEmail(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }

        userService.save(userReverseConverter.convert(user));
    }
}
