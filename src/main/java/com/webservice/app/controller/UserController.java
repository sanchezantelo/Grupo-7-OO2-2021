package com.webservice.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webservice.app.helpers.ViewRouteHelper;
import com.webservice.app.models.UsuarioModel;
import com.webservice.app.services.IUsuarioService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.USER_LOGIN;
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.USER_LOGOUT;
	}

	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return "redirect:/index";
	}

	
	@GetMapping("abm-usuario")
	public String abmUsuario(Model model) {
		model.addAttribute("usuarioModel", new UsuarioModel());
		return "abm-usuario";
	}

//ABM

	@PostMapping("/altaUsuario")
	public String altaUsuario(@ModelAttribute("usuarioModel") UsuarioModel usuarioModel,   RedirectAttributes redirectAttrs) {

		usuarioService.altaUsuario(usuarioModel);
	    redirectAttrs
        .addFlashAttribute("mensaje", "Agregado correctamente")
        .addFlashAttribute("clase", "success");
		return "redirect:/abm-usuario";
	}

	@GetMapping("/bajaUsuario")
	public ResponseEntity<String> bajaUsuario(@RequestParam("id") int id) {
		logger.debug("/bajaUsuario" + id);
		//usuarioService.bajaUsuario(usuarioService.findById(id));
		return new ResponseEntity<>("Usuario dado de baja exitosamente!", HttpStatus.OK);
	}

	@GetMapping("/modificacionUsuario")
	public ResponseEntity<String> modificacionUsuario(Model model, @RequestParam("id") int id) {
		logger.debug("/modificacionUsuario" + id);
		//usuarioService.modificacionUsuario(usuarioService.findById(id));
		return new ResponseEntity<>("Usuario modificado exitosamente!", HttpStatus.OK);
	}

}
