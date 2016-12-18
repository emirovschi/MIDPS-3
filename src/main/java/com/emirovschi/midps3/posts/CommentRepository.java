package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.models.CommentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentModel, Long>
{
}
