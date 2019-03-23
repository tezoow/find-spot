package com.woozet.findspot.domain.model.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Builder
public class PlaceResponse {
    @Builder.Default
    private int page = 1;
    private int total;
    @Builder.Default
    private boolean isLastPage = true;
    @Builder.Default
    private List<Place> documents = Collections.emptyList();
}
