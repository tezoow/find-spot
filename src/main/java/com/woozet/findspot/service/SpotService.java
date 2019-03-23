package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.dto.SpotDTO;
import com.woozet.findspot.domain.model.dto.SpotDTODetail;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpotService {
    List<SpotDTO> search(String keyword, Pageable pageable);
    SpotDTODetail getDetail(SpotDTO spot);
}
