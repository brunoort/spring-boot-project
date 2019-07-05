package br.com.institutointegra.api.spec.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.institutointegra.api.spec.client.dto.ClientDto;

@FeignClient(
		url="${store.url.rs-client}",
		name="rs-client"
		)
@RibbonClient(name = "rs-client")
public interface ProxyRsClient {
	
	@PostMapping("/api/")
	ClientDto save(@RequestBody ClientDto clientDto);
	
	@GetMapping("/api/all")
	List<ClientDto> listClient();
	
	@GetMapping("/api/viewPort")
	Map<String, String> viewPort();
}
