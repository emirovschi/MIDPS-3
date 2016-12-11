package com.emirovschi.midps3.tags;

import com.emirovschi.midps3.tags.models.TagModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.emirovschi.midps3.tags.TagConstants.TAGS_BY_POST_COUNT;
import static com.emirovschi.midps3.tags.TagConstants.TAGS_BY_VOTES_SUM;

@Repository
public interface TagRepository extends JpaRepository<TagModel, Long>
{
    TagModel findByName(String name);

    @Query(TAGS_BY_POST_COUNT)
    List<TagModel> findTagsSortedByPostCount(Pageable pageable);

    @Query(TAGS_BY_VOTES_SUM)
    List<TagModel> findTagsSortedByVotesSum(Pageable pageable);
}
