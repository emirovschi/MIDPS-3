package com.emirovschi.midps3.users.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<UserModel, UserDTO>
{
    @Override
    public UserDTO convert(final UserModel user)
    {
        final UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
