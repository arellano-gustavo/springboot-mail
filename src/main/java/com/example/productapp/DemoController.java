package com.example.productapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ChatbotMailSenderService;

//mvn -e spring-boot:run

@RestController
@RequestMapping(value = "/")
public class DemoController {
	
    @Autowired
    private ChatbotMailSenderService chatbotMailSenderService;
    
	@GetMapping(
			value = "/products", 
			produces = "application/json; charset=utf-8")
	public String getProducts(){
		
        this.chatbotMailSenderService.sendHtmlMailAsyncExecutor( //sendHtmlMail sendASynchronousHtmlMail
                "arellano.gustavo@gmail.com", 
                "Password Cambiado exitosamente",
                "Hola, Gustavo tu password ha cambiado." );
        
		String res="{-name-:-products-}";
		return res.replace('-', '"');
	}
	@GetMapping(
			value = "/services", 
			produces = "application/json; charset=utf-8")
	public String getServices(){
		String res="{-name-:-services-}";
		return res.replace('-', '"');
	}
	@GetMapping(
			path = "/logout",
			produces = "application/json; charset=utf-8")
	public String logout(HttpServletRequest request) throws ServletException {
		String name = "tavo";
		request.logout();
		String res="{-"+name+"-:-you have been loged out-}";
		return res.replace('-', '"');
	}
	
}
