package com.dmo.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dmo.entities.Book;
import com.dmo.helper.SessionFactoryRegistry;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		boolean flag = false;
		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Book b1 = new Book();
			
			b1.setBookId(1);
			b1.setAuthor("Wrox women");
			b1.setBookName("franslstine");
			b1.setPublishedDt(new Date());
			b1.setIsbn("ISB0019");
			session.saveOrUpdate(b1);
			System.out.println(b1.getBookId());

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				SessionFactoryRegistry.close();
			}
		}
	}
}
