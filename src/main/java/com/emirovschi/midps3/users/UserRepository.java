package com.emirovschi.midps3.users;

import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>
{
    UserModel findByEmail(final String email);
}
