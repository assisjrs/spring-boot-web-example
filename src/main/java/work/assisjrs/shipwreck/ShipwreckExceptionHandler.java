package work.assisjrs.shipwreck;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice("work.assisjrs.shipwreck")
public class ShipwreckExceptionHandler {
	@ExceptionHandler(ShipwreckNotFoundException.class)
	public ModelAndView onShipwreckNotFoundException(HttpServletRequest req, Exception e){
		ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", e);
	    mav.addObject("url", req.getRequestURL());
	    
	    return mav;
	}
}
