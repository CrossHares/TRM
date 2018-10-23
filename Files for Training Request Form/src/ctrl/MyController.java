package ctrl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import rf.dao.*;

@Controller
public class MyController {

	@RequestMapping(value="/")
	public String homeService() {
		return "home";
	}
	
	@RequestMapping(value="/readRequests")
	public String readRequestsService(ModelMap rfmap) {
		RequestFormServices objRF = new RequestFormServices();
		List<RequestForm> listofRequests = objRF.read();
		rfmap.addAttribute("values", listofRequests);
			
		return "readRequests";
	}
}
