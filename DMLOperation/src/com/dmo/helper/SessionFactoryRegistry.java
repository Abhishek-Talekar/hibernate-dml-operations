package com.dmo.helper;

import org.hibernate.SessionFactory;

public class SessionFactoryRegistry {
	private static SessionFactory sessionFactory;
	
	static {
		try {
			
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}
}
