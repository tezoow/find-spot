package com.woozet.findspot.service;

import com.woozet.findspot.domain.model.vo.Keyword;

import java.util.List;

public interface BestService {
    List<Keyword> getTop10Keywords();
}
