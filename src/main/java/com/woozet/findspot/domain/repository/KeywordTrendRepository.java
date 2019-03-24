package com.woozet.findspot.domain.repository;

import com.woozet.findspot.domain.model.entity.KeywordTrend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordTrendRepository extends JpaRepository<KeywordTrend, Long> {
}
