package com.woozet.findspot.domain.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class KeywordTrend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer seq;
    private String keyword;
    private Integer count;
}
