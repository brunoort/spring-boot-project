package br.com.institutointegra.api.spec.client.service;

import java.util.List;
import java.util.Map;

import br.com.institutointegra.api.spec.client.dto.ClientDto;

public interface ClientService {
	ClientDto save(ClientDto clienteDto);
	ClientDto saveFeign(ClientDto clienteDto);
	List<ClientDto> listClient();
	Map<String, String> viewPort();
}
