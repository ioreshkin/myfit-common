package center.myfit.starter.dto;

import jakarta.validation.constraints.NotBlank;

/** DTO for associating an image with a workout. */
public record WorkoutImageDto(
    @NotBlank(message = "workoutId cannot be empty") Long workoutId, ImageDto image) {

  /** Data Transfer Object for image details. */
  public record ImageDto(
      String original,
      @NotBlank(message = "mobile cannot be empty") String mobile,
      @NotBlank(message = "desktop cannot be empty") String desktop) {}
}
