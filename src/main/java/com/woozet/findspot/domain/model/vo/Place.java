package com.woozet.findspot.domain.model.vo;

import lombok.Data;

@Data
public class Place {
    private static final String URL_DAUM_MAP = "http://map.daum.net/link/map";

    private String id;
    private String placeName;
    private String phone;
    private String addressName;
    private String roadAddressName;
    private String x;
    private String y;
    private String placeUrl;
    private String mapLink;

    public String getMapLink() {
        return String.join("/", URL_DAUM_MAP, this.id);
    }
}
