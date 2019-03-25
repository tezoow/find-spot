package com.woozet.findspot.domain.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "keyword_trend")
@Data
@Builder
public class KeywordTrend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime snapshotTime;
    private String keyword;
    private Integer count;
}
