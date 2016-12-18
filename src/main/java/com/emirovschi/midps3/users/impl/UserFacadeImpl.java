package com.emirovschi.midps3.users.impl;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.images.dto.ImageDTO;
import com.emirovschi.midps3.users.dto.UpdateUserDTO;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.UserFacade;
import com.emirovschi.midps3.users.models.UserModel;
import com.emirovschi.midps3.users.UserService;
import com.emirovschi.midps3.users.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class UserFacadeImpl implements UserFacade
{
    @Autowired
    private UserService userService;

    @Autowired
    private Converter<UserModel, UserDTO> userConverter;

    @Autowired
    private Converter<UserDTO, UserModel> userReverseConverter;

    @Autowired
    private Converter<UserModel, ImageDTO> imageConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO getSessionUser()
    {
        return userConverter.convert(userService.getSessionUser());
    }

    @Override
    public ImageDTO getAvatar(final long id)
    {
        return imageConverter.convert(userService.getUserById(id));
    }

    @Override
    public void register(final UserDTO user) throws UserAlreadyExistsException
    {
        if (userService.getUserByEmail(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }

        userService.save(userReverseConverter.convert(user));
    }

    @Override
    public void update(final UpdateUserDTO userDTO)
    {
        final UserModel user = userService.getSessionUser();

        ofNullable(userDTO.getName()).ifPresent(user::setName);
        ofNullable(userDTO.getPassword()).map(passwordEncoder::encode).ifPresent(user::setPassword);

        userService.save(user);
    }
}
