package br.com.tarefa.api.dto;

import br.com.tarefa.api.entity.Task;
import br.com.tarefa.api.entity.enuns.TaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDate creationDate;
    private Long projectId;

    public static TaskDTO fromEntity(Task task) {
        if (task == null) {
            return null;
        }

        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus().getLabel())
                .creationDate(task.getCreationDate())
                .projectId(task.getProject() != null ? task.getProject().getId() : null)
                .build();
    }

    public Task toEntity() {
        Task task = new Task();
        task.setId(this.id);
        task.setTitle(this.title);
        task.setDescription(this.description);
        task.setStatus(TaskStatusEnum.fromName(this.status));
        task.setCreationDate(this.creationDate);
        return task;
    }
}