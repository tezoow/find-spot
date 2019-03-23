package com.woozet.findspot.api.v1;

import com.woozet.findspot.domain.model.vo.PlaceResponse;
import com.woozet.findspot.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/place")
public class PlaceController {
    private final PlaceService service;

    @GetMapping("/keywords")
    public PlaceResponse getPlaceByKeywords(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "15") int size) {
        return service.searchByKeyword(keyword, PageRequest.of(page, size));
    }

}
