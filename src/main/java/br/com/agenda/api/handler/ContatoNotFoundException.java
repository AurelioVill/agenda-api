/**
 * 
 */
package br.com.agenda.api.handler;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class ContatoNotFoundException extends RuntimeException {

	public ContatoNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
