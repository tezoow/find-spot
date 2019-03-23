package com.woozet.findspot.domain.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class KakaoResource {
    private List<SpotDTO> documents;
}
