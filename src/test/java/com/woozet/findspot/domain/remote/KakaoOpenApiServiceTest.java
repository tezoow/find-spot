package com.woozet.findspot.domain.remote;

import com.woozet.findspot.domain.model.dto.KakaoResource;
import feign.FeignException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KakaoOpenApiServiceTest {
    @Autowired
    private KaKaoOpenApiService service;

    @Test
    public void findByKeyword_정상() {
        KakaoResource response = service.findByKeyword("하동관", 1, 10);

        assertThat(response).isNotNull();
        assertThat(response.getDocuments().size()).isNotZero();
    }

    @Test(expected = FeignException.class)
    public void findByKeyword_빈문자열() {
        service.findByKeyword("", 1, 10);
    }

    @Test
    public void findByKeyword_검색결과없음() {
        KakaoResource response = service.findByKeyword("괞찮낳엲잃렇겏젃윾멶검샋겳괍앉낧옭닋깏", 1, 10);

        assertThat(response).isNotNull();
        assertThat(response.getDocuments().size()).isZero();
    }
}
