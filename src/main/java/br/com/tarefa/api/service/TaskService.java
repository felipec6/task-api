package br.com.tarefa.api.service;

import br.com.tarefa.api.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskDTO createTask(TaskDTO task);

    void deleteTask(Long id);

    Page<TaskDTO> listTasks(Pageable pageable);
}
