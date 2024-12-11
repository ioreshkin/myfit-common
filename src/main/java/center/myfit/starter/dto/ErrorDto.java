package center.myfit.starter.dto;

import java.time.LocalDateTime;

/** Error message DTO. */
public record ErrorDto(String message, int code, LocalDateTime timestamp) {}
