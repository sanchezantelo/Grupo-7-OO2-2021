package com.webservice.app.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.exceptions.TemplateInputException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public String validarFormulriosException(BindException exception, RedirectAttributes redirectAttrs) {

		if (exception.getObjectName().startsWith("usuarioModel")) {
			if (exception.hasFieldErrors("persona.dni")) {
				redirectAttrs.addFlashAttribute("errorDNI", exception.getFieldError().getDefaultMessage())
						.addFlashAttribute("clase", "alert alert-danger");
				return "redirect:/admin/usuario/abm-usuario";
			}
		}

		if (exception.getObjectName().startsWith("permisoPeriodoModel")) {
			if (exception.hasFieldErrors("rodado.dominio")) {
				redirectAttrs
						.addFlashAttribute("errorDominio",
								exception.getFieldError("rodado.dominio").getDefaultMessage())
						.addFlashAttribute("clase", "alert alert-danger");
			}

			if (exception.hasFieldErrors("persona.dni")) {
				redirectAttrs.addFlashAttribute("errorDNI", exception.getFieldError("persona.dni").getDefaultMessage())
						.addFlashAttribute("clase", "alert alert-danger");
			}
			return "redirect:/index/permiso?page=1";
		}

		if (exception.getObjectName().startsWith("permisoDiarioModel")) {
			if (exception.hasFieldErrors("persona.dni")) {
				redirectAttrs.addFlashAttribute("errorDNI", exception.getFieldError("persona.dni").getDefaultMessage())
						.addFlashAttribute("clase", "alert alert-danger");
			}
			return "redirect:/index/permiso?page=0";
		}
		return "redirect:/index";
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(TemplateInputException.class)
	public String internalError(TemplateInputException ex) {

		return "redirect:/index";
	}
}