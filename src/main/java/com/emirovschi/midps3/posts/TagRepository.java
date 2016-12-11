package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.models.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagModel, Long>
{
    TagModel findByName(String name);
}
