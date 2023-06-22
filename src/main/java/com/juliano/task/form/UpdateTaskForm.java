package com.juliano.task.form;

import org.hibernate.validator.constraints.Length;

import com.juliano.task.model.Task;
import com.juliano.task.repository.TaskRepository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UpdateTaskForm {
	@NotNull
	@NotEmpty
	@Length(max = 60)
	private String title;

	@NotNull
	@NotEmpty
	@Length(max = 300)
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Task converter(Long id, TaskRepository taskRepository) {
		Task task = taskRepository.findById(id).get();
		task.setTitle(title);
		task.setDescription(description);
		return task;
	}
	
	public Task converter() {
		return new Task(title, description);
	}

}
