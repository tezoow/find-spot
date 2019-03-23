package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.dto.SpotDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotServiceTest {
    @Autowired
    private SpotService spotService;
    private final Pageable defaultPageable = PageRequest.of(0, 10);

    @Test
    public void search_정상() {
        List<SpotDTO> result = spotService.search("하동관", defaultPageable);

        assertThat(result).isNotNull();
        assertThat(result.size()).isNotZero();
    }

    @Test
    public void search_빈문자열() {
        List<SpotDTO> result = spotService.search("", defaultPageable);

        assertThat(result).isNotNull();
        assertThat(result.size()).isZero();
    }

    @Test
    public void getDetail_정상() {

    }
}
