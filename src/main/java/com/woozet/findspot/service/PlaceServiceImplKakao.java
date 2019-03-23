package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.vo.PlaceResponse;
import com.woozet.findspot.domain.model.vo.kakao.KakaoResource;
import com.woozet.findspot.domain.remote.KaKaoOpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class PlaceServiceImplKakao implements PlaceService {
    private final KaKaoOpenApiService restService;

    @Cacheable(key = "keyword_api")
    @Override
    public PlaceResponse searchByKeyword(String keyword, Pageable requestPageable) {
        Pageable pageable = getPageable(requestPageable);
        if (StringUtils.isEmpty(keyword)) {
            return PlaceResponse.builder().build();
        }

        KakaoResource resource = restService.findByKeyword(keyword, pageable.getPageNumber(), pageable.getPageSize());

        return PlaceResponse.builder()
                .documents(resource.getDocuments())
                .page(pageable.getPageNumber())
                .total(resource.getMeta().getPageableCount())
                .isLastPage(resource.getMeta().isEnd())
                .build();
    }

    private Pageable getPageable(Pageable requestPageable) {
        // depends on api spec page
        final int PAGE_STARTS = 1;
        final int PAGE_ENDS = 45;
        final int SIZE_MAX = 15;
        int page = requestPageable.getPageNumber();
        int size = requestPageable.getPageSize();

        if (page < PAGE_STARTS) {
            page = PAGE_STARTS;
        } else if (page > PAGE_ENDS) {
            page = PAGE_ENDS;
        }

        if (size < 1 || size > 15) {
            size = SIZE_MAX;
        }

        return PageRequest.of(page, size);
    }

    @CacheEvict(value = "${cache.keyword_api.eviction_cron", allEntries = true)
    @Scheduled(cron = "0 0 * * *")
    public void evict() {}

}
