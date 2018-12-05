package br.com.agenda.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public Cliente findByNome(String nome);
	public Cliente findByEmail(String email);
	public Cliente findByCpf(String cpf);
	public Cliente findByTelefone(String telefone);


}
