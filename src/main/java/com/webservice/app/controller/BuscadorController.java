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

import com.webservice.app.models.FechaBusquedaModel;
import com.webservice.app.models.LugarModel;
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
		model.addAttribute("fechaBusquedaModel", new FechaBusquedaModel());
		model.addAttribute("lugares", lugarService.traerTodos());
		return "buscador";
	}

	// TRAER PERMISO RODADO

	@PostMapping("/traerPermisoRodado")
	public String traerPermisoPeriodo(@ModelAttribute("rodadoModel") RodadoModel rodadoModel, Model model,
			RedirectAttributes redirectAttrs) {
		logger.info("/traerPermisoRodado" + rodadoModel);
		try {
			redirectAttrs.addFlashAttribute("pperiodo", permisoService.findByRodado(rodadoModel))
					.addFlashAttribute("clase", "alert alert-success").addAttribute("page", 1);
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger")
					.addAttribute("page", 1);

		}
		return "redirect:/buscador";
	}

	// TRAER PERMISO PERIODO ACTIVOS ENTRE FECHA Y FECHA

	@PostMapping("/traerPermisoActivo")
	public String traerPermisoActivo(@ModelAttribute("fechaBusquedaModel") FechaBusquedaModel fechaBusquedaModel,
			Model model, RedirectAttributes redirectAttrs) {
		logger.info("/traerPermisoActivo" + fechaBusquedaModel);
		try {
			if(fechaBusquedaModel.getLugarOrigenModel().equals(new LugarModel()) && fechaBusquedaModel.getLugarDestinoModel().equals(new LugarModel())) {
				redirectAttrs.addFlashAttribute("lstpermisos", permisoService.findByActivoPermiso(fechaBusquedaModel))
				.addFlashAttribute("clase", "alert alert-success").addAttribute("page", 1);
			}else {
				redirectAttrs.addFlashAttribute("lstpermisos", permisoService.findByActivoPermisoLugares(fechaBusquedaModel))
				.addFlashAttribute("clase", "alert alert-success").addAttribute("page", 1);

			}
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger")
					.addAttribute("page", 1);

		}
		return "redirect:/buscador";
	}

}
