package com.webservice.app.controller;

import java.util.HashSet;
import java.util.Set;

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

import com.webservice.app.models.LugarModel;
import com.webservice.app.models.PermisoDiarioModel;
import com.webservice.app.models.PermisoModel;
import com.webservice.app.models.PermisoPeriodoModel;
import com.webservice.app.services.IPermisoService;

@Controller
@RequestMapping("/index")
public class PermisoController {

	@Autowired
	@Qualifier("permisoService")
	private IPermisoService permisoService;

	Logger logger = LoggerFactory.getLogger(PermisoController.class);
	
	
	@GetMapping("/permiso")
	public String abmPermiso(Model model) {
		model.addAttribute("lugarOrigenModel",new LugarModel());
		model.addAttribute("lugarDestinoModel",new LugarModel());
		model.addAttribute("permisoDiarioModel", new PermisoDiarioModel());
		model.addAttribute("permisoPeriodoModel", new PermisoPeriodoModel());
		//model.addAttribute("permisoModel", new PermisoPeriodoModel());
		
		return "permiso";
	}


	// ABM

	@PostMapping("/altaPermiso")
	public String altaPermiso(@ModelAttribute("permisoDiarioModel") PermisoDiarioModel permisoDiarioModel,
			RedirectAttributes redirectAttrs, @ModelAttribute("lugarOrigenModel") LugarModel lugarOrigenModel,@ModelAttribute("lugarDestinoModel") LugarModel lugarDestinoModel) {
		logger.info("/altaPermiso" + permisoDiarioModel);
		try {
			
			permisoService.altaPermiso(permisoDiarioModel,lugarOrigenModel,lugarDestinoModel);
			redirectAttrs.addFlashAttribute("mensaje", "Permiso agregado exitosamente!").addFlashAttribute("clase",
					"alert alert-success");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/index/permiso";
	}
}
