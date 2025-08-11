package br.com.tarefa.api.service.impl;

import br.com.tarefa.api.dto.TaskDTO;
import br.com.tarefa.api.entity.Project;
import br.com.tarefa.api.entity.Task;
import br.com.tarefa.api.exceptions.BusinessException;
import br.com.tarefa.api.repository.TaskRepository;
import br.com.tarefa.api.service.ProjectService;
import br.com.tarefa.api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaksServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Project project = projectService.findById(taskDTO.getProjectId());
        var taskToSave = taskDTO.toEntity();
        taskToSave.setProject(project);

        if (taskToSave.getCreationDate() == null) {
            taskToSave.setCreationDate(LocalDate.now());
        }

        return TaskDTO.fromEntity(taskRepository.save(taskToSave));
    }

    public void deleteTask(Long id) {
        var recoverdTask = getById(id);
        taskRepository.delete(recoverdTask);
    }

    public Page<TaskDTO> listTasks(Pageable pageable) {
        Page<Task> pageTask = taskRepository.findAll(pageable);
        return pageTask.map(TaskDTO::fromEntity);
    }

    protected Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new BusinessException("Task not found when searching by Id."));
    }
}

