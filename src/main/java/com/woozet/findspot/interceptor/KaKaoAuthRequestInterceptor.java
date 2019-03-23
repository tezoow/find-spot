package com.woozet.findspot.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KaKaoAuthRequestInterceptor implements RequestInterceptor {
    @Value("${constants.auth-keys.kakao}")
    private String authKey;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", String.join(" ", "KakaoAK", authKey));
    }
}
