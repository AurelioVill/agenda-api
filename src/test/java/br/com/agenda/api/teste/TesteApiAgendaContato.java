/**
 * 
 */
package br.com.agenda.api.teste;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.agenda.api.AgendaApiApplication;
import br.com.agenda.api.model.Contato;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AgendaApiApplication.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class TesteApiAgendaContato {

	private static final String API_ROOT = "http://localhost:8080/api/contatos";

	private Contato criaContatoAleatorio() {
		Contato contato = new Contato();
		contato.setEmail(RandomString.make().concat("@com.br"));
		contato.setNome(RandomString.make().concat("contato-"));
		return contato;
	}

//	private String createBookAsUri(Contato contato) {
//	   Response response = RestAssu
	         
}
