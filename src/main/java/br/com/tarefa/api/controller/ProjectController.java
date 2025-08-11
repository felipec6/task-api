package br.com.tarefa.api.controller;

import br.com.tarefa.api.dto.ProjectDTO;
import br.com.tarefa.api.dto.TaskDTO;
import br.com.tarefa.api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> listProjects(Pageable pageable) {
        return ResponseEntity.ok(projectService.listProjects(pageable));
    }
}
