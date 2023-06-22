package com.juliano.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.juliano.task.dto.TaskDTO;
import com.juliano.task.form.TaskForm;
import com.juliano.task.form.UpdateStatusTaskForm;
import com.juliano.task.form.UpdateTaskForm;
import com.juliano.task.model.Task;
import com.juliano.task.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task createTask(TaskForm task) {
		return taskRepository.save(task.converter());
	}

	public Task updateTask(Long id, UpdateTaskForm task) {
		return taskRepository.save(task.converter(id, taskRepository));
	}
	
	public Task updateTask(Long id, UpdateStatusTaskForm task) {
		return taskRepository.save(task.converter(id, taskRepository));
	}

	public Page<TaskDTO> getAllTasks(Pageable pagination) {
		Page<Task> tasks = taskRepository.findAll(pagination);
		Page<TaskDTO> tasksDTO = TaskDTO.converter(tasks);
		return tasksDTO;
	}
	
	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}
