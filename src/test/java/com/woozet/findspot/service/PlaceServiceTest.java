package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.vo.PlaceResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceServiceTest {
    @Autowired
    private PlaceService placeService;
    private final Pageable defaultPageable = PageRequest.of(1, 10);

    @Test
    public void search_정상() {
        PlaceResponse result = placeService.searchByKeyword("치킨", defaultPageable);
        log.info("result : {}", result);

        assertThat(result.getDocuments()).isNotNull();
        assertThat(result.getDocuments().size()).isNotZero();
        assertThat(result.isLastPage()).isFalse();
        assertThat(result.getPage()).isEqualTo(defaultPageable.getPageNumber());
    }

    @Test
    public void search_빈문자열() {
        PlaceResponse result = placeService.searchByKeyword("", defaultPageable);
        assertForEmptyResult(result);
    }

    @Test
    public void search_검색결과없음() {
        PlaceResponse result = placeService.searchByKeyword("괞찮낳엲잃렇겏젃윾멶검샋겳괍앉낧옭닋깏", defaultPageable);
        assertForEmptyResult(result);

    }

    private void assertForEmptyResult(PlaceResponse result) {
        assertThat(result.getDocuments()).isNotNull();
        assertThat(result.getDocuments().size()).isZero();
        assertThat(result.isLastPage()).isTrue();
        assertThat(result.getTotal()).isZero();
        assertThat(result.getPage()).isEqualTo(defaultPageable.getPageNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void search_잘못된_페이지번호() {
        placeService.searchByKeyword("", PageRequest.of(0, 10));
    }
}
