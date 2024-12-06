package center.myfit.starter.dto;

import javax.validation.constraints.NotBlank;

/**
 * Data Transfer Object for associating an image with an exercise.
 */
public record ExerciseImageDto(
        @NotBlank(message = "exerciseId cannot be empty")
        Long exerciseId,

        ImageDto image
) {
  /**
  * Data Transfer Object for image details.
  */
  public record ImageDto(
          String original,

          @NotBlank(message = "mobile cannot be empty")
          String mobile,

          @NotBlank(message = "desktop cannot be empty")
          String desktop
  ) {
  }
}