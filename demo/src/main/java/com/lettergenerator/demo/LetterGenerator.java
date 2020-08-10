package com.lettergenerator.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class LetterGenerator{
	
	private static final String LETTER_TYPE = "letterType";
	
	@Cacheable(cacheNames="letterDao")
	public ModelAndView build(Map<String, Object> letterDao) {
		
        letterDao.put("date", new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
        
        ModelAndView mv = new ModelAndView();
        mv.addAllObjects(letterDao);
        mv.setViewName((String) letterDao.get(LETTER_TYPE));
        
        return mv;
    }
	
	@CacheEvict(cacheNames="letterDao", allEntries=true)
	public void flushCache() {
	}
}