package com.woozet.findspot.domain.remote;

import com.woozet.findspot.domain.model.vo.kakao.KakaoResource;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class KakaoOpenApiServiceTest {
    @Autowired
    private KaKaoOpenApiService service;

    @Test
    public void findByKeyword_정상_많은건수() {
        KakaoResource response = service.findByKeyword("치킨", 1, 15);
        log.info("response : {}", response);


        assertThat(response).isNotNull();
        assertThat(response.getDocuments().size()).isNotZero();
        assertThat(response.getMeta().isEnd()).isFalse();
    }

    @Test
    public void findByKeyword_정상_1페이지() {
        KakaoResource response = service.findByKeyword("하동관", 1, 15);
        log.info("response : {}", response);

        assertThat(response).isNotNull();
        assertThat(response.getDocuments().size()).isNotZero();
        assertThat(response.getMeta().isEnd()).isTrue();
    }

    @Test(expected = FeignException.class)
    public void findByKeyword_빈문자열() {
        service.findByKeyword("", 1, 15);
    }

    @Test
    public void findByKeyword_검색결과없음() {
        KakaoResource response = service.findByKeyword("괞찮낳엲잃렇겏젃윾멶검샋겳괍앉낧옭닋깏", 1, 15);

        assertThat(response).isNotNull();
        assertThat(response.getDocuments().size()).isZero();
    }
}
