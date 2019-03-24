package com.woozet.findspot.aspect;

import com.woozet.findspot.domain.model.SortedKeywordQuerySet;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class SearchQueryAspect {
    private final SortedKeywordQuerySet sortedKeywordQuerySet;

    @Before("execution(* com.woozet.findspot.service.PlaceService.searchByKeyword(..)) && args(query, ..)")
    public void setSearchQueriesToSortedSet(JoinPoint joinPoint, String query) {
        sortedKeywordQuerySet.set(query);
    }
}
