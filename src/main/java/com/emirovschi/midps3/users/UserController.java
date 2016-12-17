package com.emirovschi.midps3.users;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.exceptions.NotFoundException;
import com.emirovschi.midps3.exceptions.dto.ErrorDTO;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private Converter<Exception, ErrorDTO> errorConverter;

    @RequestMapping(method = GET)
    public UserDTO get() throws NotFoundException
    {
        return userFacade.getSessionUser();
    }

    @RequestMapping(method = POST)
    public void register(@Validated @RequestBody final UserDTO user) throws UserAlreadyExistsException
    {
        userFacade.register(user);
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ErrorDTO handleBadImageException(UserAlreadyExistsException exception)
    {
        return errorConverter.convert(exception);
    }
}
