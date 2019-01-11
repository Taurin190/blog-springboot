package com.taurin190.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeadEntity {
    String title;
    String description;
    String shareUrl;
    String keyword;
}
