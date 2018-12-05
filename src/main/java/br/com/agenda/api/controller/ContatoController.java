/**
 * 
 */
package br.com.agenda.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.api.handler.ContatoNotFoundException;
import br.com.agenda.api.model.Contato;
import br.com.agenda.api.service.ContatoService;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="localhost:8080/api/contatos")
public class ContatoController {

	@Autowired
	private ContatoService service;

	@GetMapping("/contatos")
	public List<Contato> list() {
		List<Contato> contatos = this.service.listContatos();
		return contatos;
	}

	@PostMapping("/contatos")
	public void save(@Valid @RequestBody Contato contato, HttpServletResponse response) {
		this.service.save(contato);
	}

	@DeleteMapping("/contatos")
	public void remove(@RequestBody Contato contato) {
		this.service.removeContato(contato);
	}

	@DeleteMapping("/contatos/{id}")
    public void delete(@PathVariable Long id) {
		Contato contato = service.getById(id);
		if(contato != null) {
			service.removeContatoById(id);
		}else {
			throw new ContatoNotFoundException("Contato não encontrado", null);
		}
	}
	
	@PutMapping("/contatos")
	public void update(@RequestBody Contato contato) {
		this.service.updateContato(contato);
	}
	
	@GetMapping("/contatos/{nome}")
	public Contato buscaPorNome(@PathVariable String nome) {
		Contato contato = this.service.buscaPorNome(nome);
		return contato;
	}
	
	@GetMapping("/buscarPorEmail/{email}")
	public Contato buscaPorEmail(@PathVariable String email) {
		Contato contato = this.service.buscaPorEmail(email);
		return contato;
	}
}
