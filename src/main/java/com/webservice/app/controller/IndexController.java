package com.webservice.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webservice.app.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class IndexController {

	
	@GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
        return mAV;
    }

}
