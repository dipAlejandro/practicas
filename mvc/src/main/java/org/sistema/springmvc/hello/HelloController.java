package org.sistema.springmvc.hello;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	public HelloController() {
		System.out.println("BEAN instantiated");
	}
	
	@RequestMapping("/hello")
	public String sayHello(Map<String, Object> model) {
		
		model.put("greet", "Hello World, wellcome to my app.");
		
		return "hello";
	}
}
