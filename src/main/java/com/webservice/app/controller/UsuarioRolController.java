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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webservice.app.models.UsuarioRolModel;
import com.webservice.app.services.IUsuarioRolService;

@Controller
@RequestMapping("/admin/rol")
public class UsuarioRolController {

	@Autowired
	@Qualifier("usuarioRolService")
	private IUsuarioRolService usuarioRolService;

	Logger logger = LoggerFactory.getLogger(UsuarioRolController.class);

	@GetMapping("/abm-rol")
	public String abmRol(Model model) {
		model.addAttribute("usuarioRolModel", new UsuarioRolModel());
		model.addAttribute("lstRoles", usuarioRolService.findAll());
		return "abm-rol";
	}

	// ABM

	@PostMapping("/altaUsuarioRol")
	public String altaUsuarioRol(@ModelAttribute("usuarioRolModel") UsuarioRolModel usuarioRolModel,
			RedirectAttributes redirectAttrs) {
		logger.info("/altaUsuarioRol" + usuarioRolModel);
		try {
			usuarioRolService.altaUsuarioRol(usuarioRolModel);
			redirectAttrs.addFlashAttribute("mensaje", "Rol agregado exitosamente!").addFlashAttribute("clase",
					"alert alert-success");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/admin/rol/abm-rol";
	}

	@GetMapping("/bajaUsuarioRol")
	public String bajaUsuarioRol(@RequestParam("id") int id, RedirectAttributes redirectAttrs) {
		logger.info("/bajaUsuarioRol" + id);
		try {
			usuarioRolService.bajaUsuarioRol(id);
			redirectAttrs.addFlashAttribute("mensaje", "Rol dado de baja exitosamente!").addFlashAttribute("clase",
					"alert alert-success");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/admin/rol/abm-rol";
	}

	@PostMapping("/modificacionUsuarioRol")
	public String modificacionUsuarioRol(@ModelAttribute("usuarioModelUpdate") UsuarioRolModel usuarioRolModelUpdate,
			RedirectAttributes redirectAttrs) {
		logger.info("/modificacionUsuario" + usuarioRolModelUpdate);
		try {
			usuarioRolService.modificacionUsuarioRol(usuarioRolModelUpdate);
			redirectAttrs.addFlashAttribute("mensaje", "Rol modificado exitosamente!").addFlashAttribute("clase",
					"alert alert-success");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
		}
		return "redirect:/admin/rol/abm-rol";
	}

	@GetMapping("/traerUsuarioRol")
	public String traerUsuarioRol(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttrs) {
		logger.info("/traerRol" + id);
		model.addAttribute("editar", true);
		redirectAttrs.addFlashAttribute("usuarioRolModelUpdate", usuarioRolService.traerUsuarioRol(id))
				.addFlashAttribute("clase", "alert alert-success");
		return "redirect:/admin/rol/abm-rol";
	}

}
