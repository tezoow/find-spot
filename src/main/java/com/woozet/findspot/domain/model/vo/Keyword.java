package com.woozet.findspot.domain.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Keyword implements Comparable<Keyword> {
    private String keyword;
    private int count;

    public void increment() {
        this.count++;
    }

    @Override
    public int compareTo(Keyword o) {
        if (this.keyword.equals(o.getKeyword()))
            return 0;

        if (o.count - this.count == 0)
            return this.keyword.compareTo(o.getKeyword());

        return o.count - this.count;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Keyword) {
            return this.keyword.equals(((Keyword)obj).getKeyword());
        }

        return super.equals(obj);
    }
}
