package com.sg.oracle.hr.utility.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sg.oracle.model.entity.BusTicket;
import com.sg.oracle.model.service.BusTicketService;

@FacesConverter("busTicketConverter")
public class BusTicketConverter implements Converter {

	@Autowired
	private BusTicketService busTicketService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		// TODO Auto-generated method stub
		if (value != null) {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			ServletContext sc = request.getServletContext();

			busTicketService = (BusTicketService) WebApplicationContextUtils.getWebApplicationContext(sc)
					.getBean("busTicketService");

			//return busTicketService.getIdyeGoreDepartment(Integer.parseInt(value));
			return new BusTicket();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (value instanceof BusTicket && value != null)
			return String.valueOf(((BusTicket) value).getTicketID());
		else
			return null;
	}

}
