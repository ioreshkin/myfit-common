package center.myfit.starter.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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

    @Pattern(regexp = "^(http|https)://.*|^$", message = "Must be a valid URL or empty")
    String videoUrl, // Используем @Pattern для валидации URL

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