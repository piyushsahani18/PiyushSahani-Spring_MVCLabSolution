package com.greatlearning.collegefest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.collegefest.model.Student;

@Service
public class CollegeFestServiceImp implements CollegeFestService{
	
	
	private SessionFactory sessionFactory;

    private Session session;

    @Autowired
    public CollegeFestServiceImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException ex) {
            session = sessionFactory.openSession();
        }
    }


    @Override
    @Transactional
	public void insert(Student theStudent) {
		Transaction tx = session.beginTransaction();
        session.saveOrUpdate(theStudent);
        tx.commit();
	}
    
	@Override
	@Transactional
	public List<Student> allStudent() {
		Transaction tx = session.beginTransaction();
        List<Student> students = session.createQuery("from Student").list();
        tx.commit();
        return students;
	}

	@Override
	@Transactional
	public void deleteById(int student_id) {
		 Transaction tx = session.beginTransaction();
	        Student student = session.get(Student.class, student_id);
	        if (student != null)
	            session.delete(student);
	        tx.commit();
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, theId);
        tx.commit();
        return student;
	}

	 
	
}
