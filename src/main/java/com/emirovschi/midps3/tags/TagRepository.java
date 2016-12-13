package com.emirovschi.midps3.tags;

import com.emirovschi.midps3.tags.models.TagModel;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static com.emirovschi.midps3.tags.TagConstants.SEARCH_TAGS;

@Repository
public interface TagRepository extends JpaRepository<TagModel, Long>
{
    TagModel findByName(String name);

    @Query(SEARCH_TAGS)
    List<TagModel> findTags(@Param("query") String query, @Param("adds") Set<TagModel> adds,
                            @Param("excludes") Set<TagModel> excludes);
}
