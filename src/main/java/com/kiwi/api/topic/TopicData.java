package com.kiwi.api.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicData(
        @NotBlank String title,
        @NotBlank String message,
        @NotNull LocalDateTime date,
        @NotNull Status status,
        @NotBlank String author,
        @NotBlank String course) {


}

