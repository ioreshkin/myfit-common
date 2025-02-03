package center.myfit.starter.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

/** DTO for creating a workout. */
public record WorkoutDto(
    Long id,
    String keycloakId,
    @NotBlank(message = "Заголовок не может быть пустым")
    @Size(min = 3, max = 64, message = "Длинна заголовка должна быть в пределах 3-64 символа")
    String title,
    @NotNull @NotEmpty List<ExerciseWorkoutDto> exercises,
    @NotBlank(message = "Описание не может быть пустым") String description,
    ImageDto image
) {
  /** Dto for bindings exercise with workout. */
  public record ExerciseWorkoutDto(
      @NotNull Long exerciseId,
      @Min(0) Integer order,
      @NotNull @NotEmpty List<IterationDto> iterations
  ) {}

  /** Dto for iterations of exercise. */
  public record IterationDto(Integer repeats, Float weight) {}
}
