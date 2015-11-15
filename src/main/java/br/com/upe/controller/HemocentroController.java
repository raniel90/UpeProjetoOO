package br.com.upe.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.upe.model.Hemocentro;
import br.com.upe.service.HemocentroService;

@Controller
@RequestMapping("/")
public class HemocentroController {

	@Autowired
	HemocentroService service;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listHemocentros(ModelMap model) {

		List<Hemocentro> hemocentros = service.findAllHemocentros();
		model.addAttribute("hemocentros", hemocentros);
		return "hemocentroListar";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newHemocentro(ModelMap model) {
		Hemocentro hemocentro = new Hemocentro();
		model.addAttribute("hemocentro", hemocentro);
		model.addAttribute("edit", false);
		return "hemocentroCadastrar";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveHemocentro(@Valid Hemocentro hemocentro, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "hemocentroCadastrar";
		}

		if(!service.isHemocentroNomeUnique(hemocentro.getNome())){
			FieldError idError =new FieldError("hemocentro","nome",messageSource.getMessage("non.unique.nome", new String[]{hemocentro.getNome()}, Locale.getDefault()));
		    result.addError(idError);
			return "hemocentroCadastrar";
		}
		
		service.saveHemocentro(hemocentro);

		model.addAttribute("success", "Hemocentro " + hemocentro.getNome() + " registrado com sucesso");
		model.addAttribute("nameScreenList", "Listagem de Hemocentros");
		return "sucesso";
	}

	@RequestMapping(value = { "/edit-{id}-hemocentro" }, method = RequestMethod.GET)
	public String editHemocentro(@PathVariable int id, ModelMap model) {
		Hemocentro hemocentro = service.findHemocentroById(id);
		model.addAttribute("hemocentro", hemocentro);
		model.addAttribute("edit", true);
		return "hemocentroCadastrar";
	}
	
	@RequestMapping(value = { "/edit-{id}-hemocentro" }, method = RequestMethod.POST)
	public String updateHemocentro(@Valid Hemocentro hemocentro, BindingResult result,
			ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return "hemocentroCadastrar";
		}

		if(!service.isHemocentroNomeUnique(hemocentro.getNome())){
			FieldError idError =new FieldError("hemocentro","nome",messageSource.getMessage("non.unique.nome", new String[]{hemocentro.getNome()}, Locale.getDefault()));
		    result.addError(idError);
			return "hemocentroCadastrar";
		}

		service.updateHemocentro(hemocentro);

		model.addAttribute("success", "Hemocentro " + hemocentro.getNome()	+ " atualizado com sucesso");
		model.addAttribute("nameScreenList", "Listagem de Hemocentros");
		return "sucesso";
	}

	
	@RequestMapping(value = { "/delete-{id}-hemocentro" }, method = RequestMethod.GET)
	public String deleteHemocentro(@PathVariable int id) {
		service.deleteHemocentroById(id);
		return "redirect:/list";
	}

}
