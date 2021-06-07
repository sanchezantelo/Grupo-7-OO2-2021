package com.webservice.app.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webservice.app.models.PermisoDiarioModel;
import com.webservice.app.models.PermisoPeriodoModel;
import com.webservice.app.models.PersonaModel;
import com.webservice.app.services.IPermisoService;
import com.webservice.app.services.IQRCodeGeneratorService;

@Controller
@RequestMapping("/buscarPermiso")
public class QRCodeController {

	@Autowired
	@Qualifier("qrGeneratorService")
	private IQRCodeGeneratorService qrGeneratorService;
	
	@Autowired
	@Qualifier("permisoService")
	private IPermisoService permisoService;

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

	private static final String URL_PERMISO = "http://localhost:8080/buscarPermiso?idPermiso=";

	Logger logger = LoggerFactory.getLogger(QRCodeController.class);

	@GetMapping("")
	public String buscador(Model model) {
		model.addAttribute("personaModel", new PersonaModel());
		model.addAttribute("permisoDiarioModel", new PermisoDiarioModel());
		model.addAttribute("permisoPeriodoModel", new PermisoPeriodoModel());


		return "qrbuscador";
    }
	
	// TRAER PERMISO POR QR

		@PostMapping("/traerPermisoQR")
		public void traerPermiso(@ModelAttribute("personaModel") PersonaModel personaModel, Model model,
				RedirectAttributes redirectAttrs,HttpServletResponse response) {
			logger.info("/traerPermisoDiario" + personaModel);
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			
			try {
				InputStream targetStream = new ByteArrayInputStream(qrGeneratorService.getQRCodeImage(URL_PERMISO+permisoService.findByPersonaDiario(personaModel.getDni()).getIdPermiso(), 400, 400));
				 IOUtils.copy(targetStream, response.getOutputStream());
				
			} catch (Exception e) {
				redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger")
				;

			}
		}

}
