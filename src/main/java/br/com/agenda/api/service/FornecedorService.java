package br.com.agenda.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.api.model.Fornecedor;
import br.com.agenda.api.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository repository;
	
	@Transactional
	public void save(Fornecedor fornecedor) {
		this.repository.save(fornecedor);
	}
	
	@Transactional(readOnly=true)
	public List<Fornecedor> listFornecedor(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void removeFornecedor(Fornecedor fornecedor) {
		this.repository.delete(fornecedor);
	}
	
	@Transactional
	public void removeFornecedorById(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional
	public void updateFornecedor(Fornecedor fornecedor) {
		this.repository.saveAndFlush(fornecedor);
	}
	
	@Transactional(readOnly=true)
	public Fornecedor getById(Long id) {
		return this.repository.getOne(id);
	}
	
	@Transactional(readOnly=true)
	public Fornecedor buscaPorNome(String nome) {
		return this.repository.findByNome(nome);
	}
	
	@Transactional(readOnly=true)
	public Optional<Fornecedor> buscaPorId(Long id) {
		return this.repository.findById(id);
	}
	
	
	

}
