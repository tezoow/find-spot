package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.SortedKeywordQuerySet;
import com.woozet.findspot.domain.model.vo.Keyword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BestServiceImpl implements BestService {
    private final SortedKeywordQuerySet sortedKeywordQuerySet;

    @Override
    public List<Keyword> getTop10Keywords() {
        return sortedKeywordQuerySet.getTop10();
    }
}
