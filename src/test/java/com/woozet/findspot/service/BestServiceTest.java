package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.SortedKeywordQuerySet;
import com.woozet.findspot.domain.model.vo.Keyword;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BestServiceTest {
    @Autowired
    private BestService bestService;
    @Autowired
    private SortedKeywordQuerySet sortedKeywordQuerySet;

    @Before
    public void setup() {
        sortedKeywordQuerySet.reset();
    }

    @Test
    public void getTop10Keyword_정상() {
        List<String> queries = Arrays.asList(
                "성남시청",
                "카카오뱅크",
                "카카오뱅크",
                "카카오뱅크",
                "여주프리미엄아울렛",
                "여주프리미엄아울렛",
                "양재코스트코",
                "카카오뱅크",
                "여주프리미엄아울렛",
                "양재코스트코",
                "여주프리미엄아울렛",
                "여주프리미엄아울렛",
                "인천공항",
                "카카오뱅크",
                "인천공항",
                "하동관",
                "인천공항",
                "하동관",
                "카카오뱅크",
                "인천공항",
                "판교현대백화점",
                "판교역1번출구",
                "판교역2번출구",
                "판교역3번출구",
                "판교역4번출구",
                "제주공항");

        sortedKeywordQuerySet.reset();
        queries.forEach(sortedKeywordQuerySet::set);
        assertSortedList(bestService.getTop10Keywords());
    }

    private void assertSortedList(List<Keyword> top10) {
        log.info("rank : {}", top10);
        assertThat(top10.size()).isEqualTo(10);
        assertThat(top10.get(0).getCount()).isEqualTo(6);
        assertThat(top10.get(0).getKeyword()).isEqualTo("카카오뱅크");
        assertThat(top10.get(9).getCount()).isEqualTo(1);
        assertThat(top10.get(9).getKeyword()).isEqualTo("판교역3번출구");
    }
}
