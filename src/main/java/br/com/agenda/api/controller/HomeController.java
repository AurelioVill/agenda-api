/**
 * 
 */
package br.com.agenda.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@RestController
public class HomeController {

	
	@Value("${spring.application.name}")
	private String nomeAplicacao;
	
	@GetMapping("/")
	public ModelAndView homePage(Model model) {
		ModelAndView mv = new ModelAndView("home");
		
		model.addAttribute("nomeAplicacao", nomeAplicacao);
		return mv;
	}
	
}
