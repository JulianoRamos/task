package com.juliano.task.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.juliano.task.enumeration.TaskStatus;
import com.juliano.task.model.Task;

public class TaskDTO {

	private Long id;

	private String title;

	private String description;

	private LocalDateTime creationDate;

	private TaskStatus status;

	public TaskDTO(Task task) {
		super();
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.creationDate = task.getCreationDate();
		this.status = task.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	public static Page<TaskDTO> converter(Page<Task> tasks) {
		return tasks.map(TaskDTO::new);
	}

}
