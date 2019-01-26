package com.taurin190.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "tagList")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blog")
public class BlogEntity  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "english_title")
    String englishTitle;
    @Column(nullable = false)
    String title;
    @Column(name = "summary", nullable = false)
    String summary;
    @Column(name = "published_date", nullable = false)
    String publishedDate;
    @Column(name = "blog_body", columnDefinition = "TEXT")
    String blogBody;
    @Column(name = "is_valid", columnDefinition = "bit default 0")
    boolean isValid;
    @Column(name = "author_id", columnDefinition = "int default 1")
    Integer authorId;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name="jnd_blog_tag", joinColumns = { @JoinColumn( name = "blog_id") },
            inverseJoinColumns = { @JoinColumn(name="tag_id") })
    Set<TagEntity> tagList = new HashSet<>( );
}