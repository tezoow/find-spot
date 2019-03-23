package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.vo.PlaceResponse;
import org.springframework.data.domain.Pageable;

public interface PlaceService {
    PlaceResponse searchByKeyword(String keyword, Pageable pageable);
}
