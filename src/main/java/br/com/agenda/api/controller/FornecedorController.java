package br.com.agenda.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.api.handler.ContatoNotFoundException;
import br.com.agenda.api.model.Fornecedor;
import br.com.agenda.api.service.FornecedorService;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="localhost:8080/api/contatos")
public class FornecedorController {
	
	@Autowired
	private FornecedorService service;
	
	@GetMapping("/fornecedores")
	public List<Fornecedor> list() {
		List<Fornecedor> fornecedores = this.service.listFornecedor();
		return fornecedores;
	}

	@PostMapping("/fornecedores")
	public void save(@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response) {
		this.service.save(fornecedor);
	}

	@DeleteMapping("/fornecedores")
	public void remove(@RequestBody Fornecedor fornecedor) {
		this.service.removeFornecedor(fornecedor);
	}

	@DeleteMapping("/fornecedores/{id}")
    public void delete(@PathVariable Long id) {
		Fornecedor fornecedor = service.getById(id);
		if(fornecedor != null) {
			service.removeFornecedorById(id);
		}else {
			throw new ContatoNotFoundException("Fornecedor não encontrado", null);
		}
	}
	
	@PutMapping("/fornecedores")
	public void update(@RequestBody Fornecedor fornecedor) {
		this.service.updateFornecedor(fornecedor);
	}
	
	@GetMapping("/fornecedores/{nome}")
	public Fornecedor buscaPorNome(@PathVariable String nome) {
		Fornecedor fornecedor = this.service.buscaPorNome(nome);
		return fornecedor;
	}
	
	@GetMapping("/fornecedores/{id}")
	public Optional<Fornecedor> buscaPorId(@PathVariable Long id) {
		Optional<Fornecedor> fornecedor = this.service.buscaPorId(id);
		return fornecedor;
	}
	
	

}
