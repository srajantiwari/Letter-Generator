package com.lettergenerator.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	private static final String LETTER_TYPE = "letterType";
	private static final String SICK_LEAVE_LETTER = "sickLeaveLetter";
	private static final String OUTSTATION_LEAVE_LETTER = "outstationLeaveLetter";
	
	@Autowired
	private LetterGenerator letterGenerator;
	
	@RequestMapping("/")
	public ModelAndView showIndexPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/sickLeaveForm")
	public ModelAndView showSickLeaveFormPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sickLeaveForm");
		return mv;
	}
	
	@RequestMapping("/outstationLeaveForm")
	public ModelAndView showOustationLeaveFormPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("outstationLeaveForm");
		return mv;
	}
	
	@RequestMapping(value = "/generateSickLeaveLetter", method = RequestMethod.GET)
	public ModelAndView getGeneratedSickLeaveLetter(@RequestParam Map<String,Object> letterDao) {
		letterDao.put(LETTER_TYPE, SICK_LEAVE_LETTER);
		return letterGenerator.build(letterDao);
	}
	
	@RequestMapping(value = "/generateOutstationLeaveLetter", method = RequestMethod.GET)
	public ModelAndView getGeneratedOutstationLeaveLetter(@RequestParam Map<String,Object> letterDao) {
		letterDao.put(LETTER_TYPE, OUTSTATION_LEAVE_LETTER);
		return letterGenerator.build(letterDao);
	}

}
