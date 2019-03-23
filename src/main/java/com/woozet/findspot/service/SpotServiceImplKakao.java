package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.vo.SpotResponse;
import com.woozet.findspot.domain.model.vo.kakao.KakaoResource;
import com.woozet.findspot.domain.remote.KaKaoOpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class SpotServiceImplKakao implements SpotService {
    private final KaKaoOpenApiService restService;

    @Cacheable(key = "keyword_api")
    @Override
    public SpotResponse search(String keyword, Pageable pageable) {
        if (pageable.getPageNumber() < 1) {
            throw new IllegalArgumentException("Index of page must start with 1");
        }
        if (StringUtils.isEmpty(keyword)) {
            return SpotResponse.builder().build();
        }

        KakaoResource resource = restService.findByKeyword(keyword, pageable.getPageNumber(), pageable.getPageSize());

        return SpotResponse.builder()
                .documents(resource.getDocuments())
                .page(pageable.getPageNumber())
                .total(resource.getMeta().getTotalCount())
                .isLastPage(resource.getMeta().isEnd())
                .build();
    }

    @CacheEvict(value = "${cache.keyword_api.eviction_cron", allEntries = true)
    @Scheduled(cron = "0 0 * * *")
    public void evict() {}

}
