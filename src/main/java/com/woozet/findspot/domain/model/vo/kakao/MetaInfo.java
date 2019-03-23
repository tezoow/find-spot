package com.woozet.findspot.domain.model.vo.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MetaInfo {
    private int pageableCount;
    private int totalCount;
    @JsonProperty("is_end")
    private boolean isEnd;
}
