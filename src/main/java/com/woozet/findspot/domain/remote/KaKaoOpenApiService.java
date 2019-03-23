package com.woozet.findspot.domain.remote;

import com.woozet.findspot.domain.model.dto.KakaoResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakao", url = "${feign.kakao.url}")
public interface KaKaoOpenApiService {
    @GetMapping("/local/search/keyword.json")
    KakaoResource findByKeyword(
            @RequestParam("query") String keyword,
            @RequestParam("page") int page,
            @RequestParam("size") int size);
}
