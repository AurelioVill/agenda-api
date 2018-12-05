package br.com.agenda.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.api.handler.ContatoNotFoundException;
import br.com.agenda.api.model.Cliente;
import br.com.agenda.api.service.ClienteService;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="localhost:8080/api/contatos")
public class ClienteController {
	
	private ClienteService service;
	
	
	@GetMapping("/contatos")
	public List<Cliente> list() {
		List<Cliente> clientes = this.service.listClientes();
		return clientes;
	}

	@PostMapping("/clientes")
	public void save(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		this.service.save(cliente);
	}

	@DeleteMapping("/clientes")
	public void remove(@RequestBody Cliente cliente) {
		this.service.removeCliente(cliente);
	}

	@DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable Long id) {
		Cliente cliente = service.getById(id);
		if(cliente != null) {
			service.removeClienteById(id);
		}else {
			throw new ContatoNotFoundException("Cliente não encontrado", null);
		}
	}
	
	@PutMapping("/clientes")
	public void update(@RequestBody Cliente cliente) {
		this.service.updateCliente(cliente);
	}
	
	@GetMapping("/clientes/{nome}")
	public Cliente buscaPorNome(@PathVariable String nome) {
		Cliente cliente = this.service.buscaPorNome(nome);
		return cliente;
	}
	
	@GetMapping("/clientes/{id}")
	public Optional<Cliente> buscaPorId(@PathVariable Long id) {
		Optional<Cliente> cliente = this.service.buscaPorId(id);
		return cliente;
	}

}
