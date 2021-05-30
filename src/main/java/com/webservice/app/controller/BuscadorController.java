package com.webservice.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webservice.app.models.RodadoModel;
import com.webservice.app.services.ILugarService;
import com.webservice.app.services.IPermisoService;

@Controller
@RequestMapping("/buscador")
public class BuscadorController {

	@Autowired
	@Qualifier("permisoService")
	private IPermisoService permisoService;

	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;

	Logger logger = LoggerFactory.getLogger(BuscadorController.class);

	@GetMapping("")
	public String buscador(Model model) {
		model.addAttribute("rodadoModel", new RodadoModel());
		return "buscador";
	}

	// TRAER PERMISO
	@PostMapping("/traerPermisoRodado")
	public String traerPermisoPeriodo(@ModelAttribute("rodadoModel") RodadoModel rodadoModel, Model model,
			RedirectAttributes redirectAttrs) {
		logger.info("/traerPermisoRodado" + rodadoModel);
		redirectAttrs.addFlashAttribute("pperiodo", permisoService.findByRodado(rodadoModel))
				.addFlashAttribute("clase", "alert alert-success").addAttribute("page", 1);
		return "redirect:/buscador";
	}
}
