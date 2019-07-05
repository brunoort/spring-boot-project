package br.com.institutointegra.api.client.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.institutointegra.api.client.model.Client;
import br.com.institutointegra.api.client.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Client API", description = "Operations to Client")
public class ClientResource {

	@Value("${server.port}")
	private String port;
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/viewPort")
	public Map<String, String> viewPort(){
		Map<String, String> viewPort = new HashMap<>();
		viewPort.put("port", this.port);
		
		return viewPort;
	}
	
	@ApiOperation(value = "View list Client")
	@GetMapping("/all")
	public List<Client> getAll(){
		return this.clientService.getAll();
	}
	
	@PostMapping("/")
	public Client save(@RequestBody Client client) {
		return this.clientService.save(client);
	}
	
	@PutMapping("/{id}")
	public Client update(
			@PathVariable(name = "id", required = false) Long idClient, 
			@RequestBody Client client
			) {
		return this.clientService.update(client);
	}
	
	@GetMapping("/{id}")
	public Client findById(@PathVariable Long id) {
		return this.clientService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  delete(@PathVariable Long id) {
		this.clientService.delete(id);
		
		return ResponseEntity.noContent().build();
	}	
}


