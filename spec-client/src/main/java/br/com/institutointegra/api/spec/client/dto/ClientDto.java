package br.com.institutointegra.api.spec.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDto {
	private Long id;
	
	private String name;
	
	@JsonProperty("idUser")
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
}
