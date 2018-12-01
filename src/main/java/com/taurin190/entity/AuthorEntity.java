package com.taurin190.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "author")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "author_name")
    String authorName;
    @Column(name = "self_introduction")
    String selfIntroduction;
    @Column(name = "twitter_Account")
    String twitterAccount;
    @Column(name = "github_Account")
    String githubAccount;
    @Column(name = "is_valid")
    boolean isValid;
}