package com.emirovschi.midps3.oauth;

import com.emirovschi.midps3.roles.RoleModel;
import com.emirovschi.midps3.users.UserRepository;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class RepositoryUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException
    {
        return ofNullable(userRepository.findByEmail(email)).map(this::getUser)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    }

    private UserDetails getUser(final UserModel user)
    {
        return new User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }

    private List<? extends GrantedAuthority> getAuthorities(final UserModel user)
    {
        return user.getRoles().stream()
                .map(RoleModel::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
