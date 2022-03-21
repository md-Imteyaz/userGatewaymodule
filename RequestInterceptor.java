package com.ZuuleGateway.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Configuration
@Component
public class RequestInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		System.out.println("in pre handler we are intercepating request");
		System.out.println("==============================");
		String RequstURI = request.getRequestURI();
		String tenantId = request.getHeader("X-Tanatid");
		System.out.println("RequestURI::" + RequstURI + "|| search for  X-tanantId" + tenantId);
		System.out.println("===================");
		if (tenantId != null) {
			response.getWriter();
			response.setStatus(400);
			return false;
		}
		TenantContext.setCurrentTenant(tenantId);
		return true;

	}
}
