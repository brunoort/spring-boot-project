package br.com.institutointegra.api.orders.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_client")
	private Long idClient;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "alter_date")
	private LocalDateTime alterDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getAlterDate() {
		return alterDate;
	}

	public void setAlterDate(LocalDateTime alterDate) {
		this.alterDate = alterDate;
	}

	
	
}
