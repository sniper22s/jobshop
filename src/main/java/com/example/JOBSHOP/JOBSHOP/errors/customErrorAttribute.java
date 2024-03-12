package com.example.JOBSHOP.JOBSHOP.errors;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;


@Component
public class customErrorAttribute extends DefaultErrorAttributes{
	
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map<String, Object> errorAttribute = super.getErrorAttributes(webRequest, options);
		
		errorAttribute.put("success", Boolean.FALSE);
		errorAttribute.put("status", errorAttribute.get("error"));
		errorAttribute.put("exception", errorAttribute.get("meesage"));
		errorAttribute.put("details", errorAttribute.get("meesage"));
		errorAttribute.remove("error");
		errorAttribute.remove("path");
		
		return errorAttribute;
	}

}
