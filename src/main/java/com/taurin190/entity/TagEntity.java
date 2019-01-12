package com.taurin190.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tag")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    @Column(name = "is_valid")
    boolean isValid;
    @Column(name = "author_id")
    Integer authorId;

    @ManyToMany
    @JoinTable(name="jnd_tag_blog", joinColumns = @JoinColumn( name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name="blog_id"))
    List<BlogEntity> blogList;
}