package center.myfit.starter.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating an exercise.
 */
public record CreateExerciseDto(
    Long id,

    @NotBlank(message = "Заголовок не может быть пустым")
    @Size(min = 3, max = 64, message = "Длинна заголовка должна быть в пределах 3-64 символа")
    String title,

    @NotBlank(message = "Описание не может быть пустым")
    String description,

    @Pattern(regexp = "^(http|https)://.*|^$", message = "Не верный формат ссылки на видео")
    String videoUrl, // Используем @Pattern для валидации URL

    ImageDto image
) {
  /**
   * DTO for image associated with an exercise.
   */
  public record ImageDto(
      String original,
      String mobile,
      String desktop
  ) {
  }
}