package com.hopsun.scenter.api.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@SuppressWarnings("unchecked")
public class SessionCounter implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		//System.out.println("session created ------------------------");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		se.getSession().invalidate();
	}

}
