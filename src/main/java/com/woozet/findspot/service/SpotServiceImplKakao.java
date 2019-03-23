package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.dto.SpotDTO;
import com.woozet.findspot.domain.model.dto.SpotDTODetail;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotServiceImplKakao implements SpotService {
    @Override
    public List<SpotDTO> search(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public SpotDTODetail getDetail(SpotDTO spot) {
        return null;
    }
}
