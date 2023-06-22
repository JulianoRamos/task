package com.juliano.task.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliano.task.dto.TaskDTO;
import com.juliano.task.form.TaskForm;
import com.juliano.task.form.UpdateStatusTaskForm;
import com.juliano.task.form.UpdateTaskForm;
import com.juliano.task.model.Task;
import com.juliano.task.service.TaskService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;

	@PostMapping
	@Transactional
	public ResponseEntity<TaskDTO> createTask(@RequestBody @Valid TaskForm taskForm) {
		Task createdTask = taskService.createTask(taskForm);
		return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTO(createdTask));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody @Valid UpdateTaskForm task) {
		Optional<Task> optional = taskService.findById(id);
		if (optional.isPresent()) {
			Task updatedTask = taskService.updateTask(id, task);
			return ResponseEntity.ok(new TaskDTO(updatedTask));
		}

		return ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}")
	@Transactional
	public ResponseEntity<TaskDTO> updateStatusTask(@PathVariable Long id,
			@RequestBody @Valid UpdateStatusTaskForm task) {
		Optional<Task> optional = taskService.findById(id);
		if (optional.isPresent()) {
			Task updatedTask = taskService.updateTask(id, task);
			return ResponseEntity.ok(new TaskDTO(updatedTask));
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<Page<TaskDTO>> getAllTasks(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		return ResponseEntity.ok(taskService.getAllTasks(pagination));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		Optional<Task> optional = taskService.findById(id);
		if (optional.isPresent()) {
			taskService.deleteTask(id);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}
