package com.woozet.findspot.domain.model;

import com.woozet.findspot.domain.model.vo.Keyword;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

@Component
public class SortedKeywordQuerySet implements InitializingBean {
    private SortedSet<Keyword> keywordRankSet;
    private Map<String, Keyword> keywordMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.keywordRankSet = new TreeSet<>();
        this.keywordMap = new HashMap<>();
    }

    public List<Keyword> getTop10() {
        int i = 0;
        List<Keyword> result = new LinkedList<>();

        for (Keyword k : this.keywordRankSet) {
            if (++i > 10)
                break;
            result.add(k);
        }

        return result;
    }

    public synchronized void set(String keyword) {
        if (StringUtils.isEmpty(keyword))
            return;

        if (!this.keywordMap.containsKey(keyword)) {
            Keyword kwd = Keyword.builder().keyword(keyword).count(1).build();
            this.keywordMap.put(keyword, kwd);
            this.keywordRankSet.add(kwd);
            return;
        }

        Keyword kwd = this.keywordMap.get(keyword);
        this.keywordRankSet.remove(kwd);
        kwd.increment();
        this.keywordRankSet.add(kwd);
    }

    public void reset() {
        this.keywordMap = new HashMap<>();
        this.keywordRankSet = new TreeSet<>();
    }
}
