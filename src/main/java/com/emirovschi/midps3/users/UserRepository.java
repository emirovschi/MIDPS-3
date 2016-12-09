package com.emirovschi.midps3.users;

import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<UserModel, Long>
{
    UserModel findByEmail(final String email);
}
