package com.codecool.GamLib.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlatformRequest {
    private final Long id;
    private final String name;
    private final String cpu_name;
    private final Float cpu_clock_speed;
    private final float memory;
    private final float internal_storage;
    private final String platform_logo;
}
