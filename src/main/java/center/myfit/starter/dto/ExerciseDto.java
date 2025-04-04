package center.myfit.starter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import org.hibernate.validator.constraints.URL;

/** DTO for creating an exercise. */
public record ExerciseDto(
    Long id,
    String keycloakId,

    @NotBlank(message = "Заголовок не может быть пустым")
    @Size(min = 3, max = 64, message = "Длинна заголовка должна быть в пределах 3-64 символа")
    String title,

    @NotBlank(message = "Описание не может быть пустым") String description,

    @URL(protocol = "https", message = "Не верный формат ссылки на видео") String videoUrl,

    List<String> tags,
    ImageDto image) {}
