package br.com.tarefa.api.service.impl;

import br.com.tarefa.api.entity.Project;
import br.com.tarefa.api.exceptions.BusinessException;
import br.com.tarefa.api.repository.ProjectRepository;
import br.com.tarefa.api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project findById(Long id) {
        return getById(id);
    }

    protected Project getById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new BusinessException("Project not found when searching by Id."));
    }
}
