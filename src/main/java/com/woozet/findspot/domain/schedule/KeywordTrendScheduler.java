package com.woozet.findspot.domain.schedule;

import com.woozet.findspot.domain.model.SortedKeywordQuerySet;
import com.woozet.findspot.domain.model.entity.KeywordTrend;
import com.woozet.findspot.domain.repository.KeywordTrendRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class KeywordTrendScheduler {
    private final KeywordTrendRepository repository;
    private final SortedKeywordQuerySet sortedKeywordQuerySet;

    @Scheduled(fixedDelay = 60000, initialDelay = 60000)
    public void saveTrendSnapshot() {
        final LocalDateTime snapshotTime = LocalDateTime.now();

        repository.saveAll(
                sortedKeywordQuerySet.getTop10()
                        .stream()
                        .map(keyword -> KeywordTrend.builder()
                                .keyword(keyword.getKeyword())
                                .count(keyword.getCount())
                                .snapshotTime(snapshotTime)
                                .build())
                        .collect(toList()));
        log.info("Keyword trend is saving at {}", snapshotTime);
    }
}
