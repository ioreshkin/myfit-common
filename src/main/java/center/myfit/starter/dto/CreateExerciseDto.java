package center.myfit.starter.dto;

import center.myfit.starter.dto.customvalidation.UrlOrEmpty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object for creating an exercise.
 */
public record CreateExerciseDto(
        Long id,

        @NotBlank(message = "Title cannot be empty")
        @Size(min = 3, max = 64, message = "Title must be between 3 and 64 characters")
        String title,

        @NotBlank(message = "Description cannot be empty")
        String description,

        @UrlOrEmpty
        String videoUrl,

        ImageDto image
) {
  /**
  * Data Transfer Object for image associated with an exercise.
  */
  public record ImageDto(
      String original,
      String mobile,
      String desktop
  ) {
  }
}