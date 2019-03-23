package com.taurin190.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "work")
public class WorkEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String url;
    @Column(name = "img_url")
    String imgUrl;
    @Column(nullable = false)
    String summary;
    @Column(name = "published_date", nullable = false)
    String publishedDate;
}
