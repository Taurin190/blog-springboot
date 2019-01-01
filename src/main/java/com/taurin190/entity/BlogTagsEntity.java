package com.taurin190.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "blog_tags")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogTagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name="blog_id")
    Integer blogId;

    @Column(name="tag_id")
    Integer tagId;
}
