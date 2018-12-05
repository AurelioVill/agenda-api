/**
 * 
 */
package br.com.agenda.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.api.model.Contato;
import br.com.agenda.api.repository.ContatoRepository;

/**
 * @author carlosbarbosagomesfilho
 *
 */

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;
	
	@Transactional
	public void save(Contato contato) {
		this.repository.save(contato);
	}
	
	@Transactional(readOnly=true)
	public List<Contato> listContatos(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void removeContato(Contato contato) {
		this.repository.delete(contato);
	}
	
	@Transactional
	public void removeContatoById(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional
	public void updateContato(Contato contato) {
		this.repository.saveAndFlush(contato);
	}
	
	@Transactional(readOnly=true)
	public Contato getById(Long id) {
		return this.repository.getOne(id);
	}
	
	@Transactional(readOnly=true)
	public Contato buscaPorNome(String nome) {
		return this.repository.findByNome(nome);
	}
	
	@Transactional(readOnly=true)
	public Contato buscaPorEmail(String email) {
		return this.repository.findByEmail(email);
	}
}
