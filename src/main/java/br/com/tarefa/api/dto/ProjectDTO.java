package br.com.tarefa.api.dto;

import br.com.tarefa.api.entity.Project;
import br.com.tarefa.api.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDTO {
    private Long id;
    private String name;
    private List<TaskDTO> tasks;

    public static ProjectDTO fromEntity(Project project) {
        if (project == null) return null;
        List<TaskDTO> taskDTOs = null;
        if (project.getTasks() != null) {
            taskDTOs = project.getTasks().stream()
                    .map(TaskDTO::fromEntity).toList();
        }
        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .tasks(taskDTOs)
                .build();
    }

    public Project toEntity() {
        Project project = new Project();
        project.setId(this.id);
        project.setName(this.name);
        if (this.tasks != null) {
            List<Task> taskEntities = this.tasks.stream()
                    .map(taskDTO -> {
                        Task task = taskDTO.toEntity();
                        task.setProject(project);
                        return task;
                    }).toList();
            project.setTasks(taskEntities);
        }
        return project;
    }
}
