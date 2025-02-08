package center.myfit.starter.dto;

import center.myfit.starter.enums.EntityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/** DTO for image tasks associated with an exercise. */
public record ImageTaskDto(
    @NotBlank(message = "exerciseId cannot be empty") Long objectId,
    @NotNull(message = "EntityType can not be null") EntityType entityType,
    ImageDto image) {

  /** Data Transfer Object for original image details. */
  public record ImageDto(@NotBlank(message = "original cannot be empty") String original) {}
}
