package com.webservice.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webservice.app.models.PermisoDiarioModel;
import com.webservice.app.models.PermisoPeriodoModel;
import com.webservice.app.models.PersonaModel;
import com.webservice.app.services.ILugarService;
import com.webservice.app.services.IPermisoService;

@Controller
@RequestMapping("/index")
@Validated
public class PermisoController {

	@Autowired
	@Qualifier("permisoService")
	private IPermisoService permisoService;

	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;

	Logger logger = LoggerFactory.getLogger(PermisoController.class);

	@GetMapping("/permiso")
	public String abmPermiso(Model model, @RequestParam("page") int page) {
		model.addAttribute("lugares", lugarService.findAll());
		model.addAttribute("personaModel", new PersonaModel());
		if (page == 0) {
			model.addAttribute("permisoDiarioModel", new PermisoDiarioModel());
		} else {
			model.addAttribute("permisoPeriodoModel", new PermisoPeriodoModel());
			// model.addAttribute("permisoModel", new PermisoPeriodoModel());
		}
		return "permiso";
	}

	// ABM

	// ALTA PERMISO DIARIO

	@PostMapping("/altaPermisoDiario")
	public String altaPermisoDiario(@Valid @ModelAttribute("permisoDiarioModel") PermisoDiarioModel permisoDiarioModel,
			RedirectAttributes redirectAttrs) {
		logger.info("/altaPermisoDiario " + permisoDiarioModel);
		try {

			permisoService.altaPermiso(permisoDiarioModel);
			redirectAttrs.addFlashAttribute("mensaje", "Estimado/a hemos registrado su solicitud exitosamente!")
					.addFlashAttribute("clase", "alert alert-success").addAttribute("page", 0);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger")
					.addAttribute("page", 0);
		}
		return "redirect:/index/permiso";
	}

	// ALTA PERMISO PERIODO

	@PostMapping("/altaPermisoPeriodo")
	public String altaPermisoPeriodo(@Valid @ModelAttribute("permisoPeriodoModel") PermisoPeriodoModel permisoPeriodoModel,
			RedirectAttributes redirectAttrs) {
		logger.info("/altaPermisoPeriodo " + permisoPeriodoModel);
	
		try {

			permisoService.altaPermiso(permisoPeriodoModel);
			redirectAttrs.addFlashAttribute("mensaje", "Estimado/a hemos registrado su solicitud exitosamente!")
					.addFlashAttribute("clase", "alert alert-success").addAttribute("page", 1);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger")
					.addAttribute("page", 1);
		}
		return "redirect:/index/permiso";
	}

	// TRAER PERMISO PERIODO

	@PostMapping("/traerPermisoPeriodo")
	public String traerPermisoPeriodo(@ModelAttribute("personaModel") PersonaModel personaModel, Model model,
			RedirectAttributes redirectAttrs) {
		logger.info("/traerPermisoPeriodo" + personaModel);
		try {
			redirectAttrs.addFlashAttribute("pperiodo", permisoService.findByPersonaPeriodo(Long.valueOf(personaModel.getDni())))
					.addFlashAttribute("clase", "alert alert-success").addAttribute("page", 1);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger")
			.addAttribute("page", 1);

		}
		return "redirect:/index/permiso";
	}

	// TRAER PERMISO DIARIO

	@PostMapping("/traerPermisoDiario")
	public String traerPermisoDiario(@ModelAttribute("personaModel") PersonaModel personaModel, Model model,
			RedirectAttributes redirectAttrs) {
		logger.info("/traerPermisoDiario" + personaModel);
		try {
			redirectAttrs.addFlashAttribute("pdiario", permisoService.findByPersonaDiario(Long.valueOf(personaModel.getDni())))
					.addFlashAttribute("clase", "alert alert-success").addAttribute("page", 0);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger")
			.addAttribute("page", 0);

		}
		return "redirect:/index/permiso";
	}

}
