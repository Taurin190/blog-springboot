package com.taurin190.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "blog")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany(mappedBy = "blogList")
    List<TagEntity> tagList;
}