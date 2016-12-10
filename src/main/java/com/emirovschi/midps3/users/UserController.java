package com.emirovschi.midps3.users;

import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController("/users")
public class UserController
{
    @Autowired
    private UserFacade userFacade;

    @RequestMapping(method = POST)
    public void register(@Validated @RequestBody final UserDTO user)
            throws UserAlreadyExistsException
    {
        userFacade.register(user);
    }
}
