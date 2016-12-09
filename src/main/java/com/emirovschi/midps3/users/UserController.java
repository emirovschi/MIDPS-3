package com.emirovschi.midps3.users;

import com.emirovschi.midps3.validators.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController("/users")
public class UserController
{
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private GenericValidator<UserDTO> userValidator;

    @RequestMapping(method = POST)
    public void register(@Validated @ModelAttribute("registerUser") @RequestBody UserDTO user)
    {

    }

    @InitBinder(value = "registerUser")
    public void dataBinding(WebDataBinder binder)
    {
        binder.addValidators(userValidator);
    }
}
