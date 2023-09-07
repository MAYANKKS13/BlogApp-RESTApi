package in.stackroute.blogrestapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blogs")

public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "b_id")
    private int blogId;

    @Column(name = "b_title", nullable = false)
    private String blogTitle;

    @Column(name = "b_authName",nullable = false)
    private String authorName;

    @Column(name = "b_content", nullable = false)
    private String blogContent;


    public Blog(String blogTitle, String authorName, String blogContent)
    {
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.blogContent = blogContent;
    }
}
