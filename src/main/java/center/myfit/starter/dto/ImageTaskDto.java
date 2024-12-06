package center.myfit.starter.dto;

import javax.validation.constraints.NotBlank;

/**
 * Data Transfer Object for image tasks associated with an exercise.
 */
public record ImageTaskDto(
        @NotBlank(message = "exerciseId cannot be empty")
        Long exerciseId,

        ImageDto image
) {
  /**
  * Data Transfer Object for original image details.
  */
  public record ImageDto(
          @NotBlank(message = "original cannot be empty")
          String original
  ) {
  }
}