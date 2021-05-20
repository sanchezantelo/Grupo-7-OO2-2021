
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

import com.webservice.app.models.UsuarioModel;
import com.webservice.app.services.IUsuarioRolService;
import com.webservice.app.services.IUsuarioService;

@Controller
@RequestMapping("/admin/usuario")
public class UserController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("usuarioRolService")
	private IUsuarioRolService usuarioRolService;


	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/abm-usuario")
	public String abmUsuario(Model model) {
        model.addAttribute("usuarioModel", new UsuarioModel());
		model.addAttribute("lstUsuarios",usuarioService.findAll());
		model.addAttribute("lstRoles",usuarioRolService.findAll());
		return "abm-usuario";
	}

//ABM

	@PostMapping("/altaUsuario")
	public String altaUsuario(@ModelAttribute("usuarioModel") UsuarioModel usuarioModel,   RedirectAttributes redirectAttrs) {
        logger.info("/altaUsuario"+usuarioModel);
		try {
			usuarioService.altaUsuario(usuarioModel);
			redirectAttrs
		    .addFlashAttribute("mensaje","Usuario agregado exitosamente")
		    .addFlashAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			redirectAttrs
	        .addFlashAttribute("error",e.getMessage())
	        .addFlashAttribute("clase", "alert alert-danger");
		}
	 
		return "redirect:/admin/usuario/abm-usuario";
	}

	@GetMapping("/bajaUsuario")
	public String bajaUsuario(@RequestParam("id") int id, RedirectAttributes redirectAttrs) {
		logger.info("/bajaUsuario" + id);
		usuarioService.bajaUsuario(id);
		 redirectAttrs
	        .addFlashAttribute("mensaje","Usuario dado de baja exitosamente")
	        .addFlashAttribute("clase", "alert alert-success");
		return "redirect:/admin/usuario/abm-usuario";
	}

	@PostMapping("/modificacionUsuario")
	public String modificacionUsuario(@ModelAttribute("usuarioModelUpdate") UsuarioModel usuarioModelUpdate, RedirectAttributes redirectAttrs) {
		logger.info("/modificacionUsuario" + usuarioModelUpdate);
		try {
			usuarioService.modificacionUsuario(usuarioModelUpdate);
			 redirectAttrs
		        .addFlashAttribute("mensaje","Usuario modificado exitosamente")
		        .addFlashAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			redirectAttrs
	        .addFlashAttribute("error",e.getMessage())
	        .addFlashAttribute("clase", "alert alert-danger");
		}

		return "redirect:/admin/usuario/abm-usuario";
	}

	@GetMapping("/traerUsuario")
	public String traerUsuario(@RequestParam("id") int id,Model model, RedirectAttributes redirectAttrs) {
		logger.info("/traerUsuario" + id);
		 model.addAttribute("editar", true);
		 redirectAttrs
	        .addFlashAttribute("usuarioModelUpdate",usuarioService.traerUsuario(id))
	        .addFlashAttribute("clase", "alert alert-success");
		return "redirect:/admin/usuario/abm-usuario";
	}
}
