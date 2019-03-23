package com.woozet.findspot.domain.model.vo.kakao;

import com.woozet.findspot.domain.model.vo.Place;
import lombok.Data;

import java.util.List;

@Data
public class KakaoResource {
    private MetaInfo meta;
    private List<Place> documents;
}
