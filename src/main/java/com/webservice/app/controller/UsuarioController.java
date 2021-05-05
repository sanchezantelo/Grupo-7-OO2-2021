package com.webservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.webservice.app.helpers.ViewRouteHelper;
import com.webservice.app.models.UsuarioModel;
import com.webservice.app.services.IUsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USUARIO_INDEX);
		mAV.addObject("usuario", usuarioService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USUARIO_NEW);
		mAV.addObject("usuario", new UsuarioModel());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		usuarioService.insertOrUpdate(usuarioModel);
		return new RedirectView(ViewRouteHelper.USUARIO_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int idUsuario) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USUARIO_UPDATE);
		mAV.addObject("usuario", usuarioService.findById(idUsuario));
		return mAV;
	}
	
	@GetMapping("/partial/{id}")
	public ModelAndView getPartial(@PathVariable("id") int idUsuario) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USUARIO_PARTIAL_VIEW);
		mAV.addObject("usuario", usuarioService.findById(idUsuario));
		return mAV;
	}

	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		usuarioService.insertOrUpdate(usuarioModel);
		return new RedirectView(ViewRouteHelper.USUARIO_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int idUsuario) {
		usuarioService.remove(idUsuario);
		return new RedirectView(ViewRouteHelper.USUARIO_ROOT);
	}
}
