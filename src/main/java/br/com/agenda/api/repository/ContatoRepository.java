/**
 * 
 */
package br.com.agenda.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.api.model.Contato;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

	public Contato findByNome(String nome);
	
	public Contato findByEmail(String email);
	
}
