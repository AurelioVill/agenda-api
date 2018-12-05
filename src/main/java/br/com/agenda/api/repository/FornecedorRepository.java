package br.com.agenda.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.api.model.Fornecedor;

@Repository
public interface FornecedorRepository  extends JpaRepository<Fornecedor, Long>{
	
	public Fornecedor findByNome(String nome);
	public Fornecedor findByEmail(String email);
	public Fornecedor findByTelefone(String telefone);
	public Fornecedor findByCnpj(String cnpj);
	public Fornecedor findByRazaoSocial(String razaoSolcial);

}
