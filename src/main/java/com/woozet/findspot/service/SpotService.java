package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.vo.SpotResponse;
import org.springframework.data.domain.Pageable;

public interface SpotService {
    SpotResponse search(String keyword, Pageable pageable);
}
