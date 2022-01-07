package io.github.niulaniobm.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Message {

	
	public static void info(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, "ao realizar cadastro."));

	}
	
	public static void erro(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "ao realizar cadastro."));

	}
	
	public static  void warn(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, "ao realizar cadastro."));

	}
	

}
