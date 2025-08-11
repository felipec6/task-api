package br.com.tarefa.api.service;

import br.com.tarefa.api.dto.ProjectDTO;
import br.com.tarefa.api.entity.Project;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    Project findById(Long id);
    List<ProjectDTO> listProjects(Pageable pageable);
}
