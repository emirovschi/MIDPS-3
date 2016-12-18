package com.emirovschi.midps3.posts.models;

import com.emirovschi.midps3.tags.models.TagModel;
import com.emirovschi.midps3.users.models.UserModel;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "posts")
public class PostModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="posts_id_seq")
    @SequenceGenerator(name="posts_id_seq", sequenceName="posts_id_seq", allocationSize=1)
    private long id;

    private String title;

    @Lob
    private Blob image;

    @Lob
    private Blob preview;

    private String imageType;

    @ManyToMany
    @JoinTable(name="postTags", joinColumns=@JoinColumn(name="post"), inverseJoinColumns=@JoinColumn(name="tag"))
    private List<TagModel> tags;

    @ElementCollection
    @JoinTable(name="votes", joinColumns=@JoinColumn(name="post"))
    @MapKeyJoinColumn(name="user")
    private Map<UserModel, Integer> votes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentModel> comments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private UserModel user;

    public long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public Blob getImage()
    {
        return image;
    }

    public void setImage(final Blob image)
    {
        this.image = image;
    }

    public String getImageType()
    {
        return imageType;
    }

    public void setImageType(final String imageType)
    {
        this.imageType = imageType;
    }

    public List<TagModel> getTags()
    {
        return tags;
    }

    public void setTags(final List<TagModel> tags)
    {
        this.tags = tags;
    }

    public Map<UserModel, Integer> getVotes()
    {
        return votes;
    }

    public void setVotes(final Map<UserModel, Integer> votes)
    {
        this.votes = votes;
    }

    public List<CommentModel> getComments()
    {
        return comments;
    }

    public void setComments(final List<CommentModel> comments)
    {
        this.comments = comments;
    }

    public UserModel getUser()
    {
        return user;
    }

    public void setUser(final UserModel user)
    {
        this.user = user;
    }

    public Blob getPreview()
    {
        return preview;
    }

    public void setPreview(final Blob preview)
    {
        this.preview = preview;
    }
}
