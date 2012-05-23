package ch.lepeit.stundenabrechnung.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ch.lepeit.stundenabrechnung.model.Verbuchbar;

@Stateless
public class AuswertungService {
	@PersistenceContext
	private EntityManager em;
	
	// TODO: Implement
	public List<Verbuchbar> getVerbuchbar(Date monat) {
		TypedQuery<Verbuchbar> q = em.createQuery("SELECT new ch.lepeit.stundenabrechnung.model.Verbuchbar(j.task.verbuchbar, SUM(stunden)) FROM Journal j WHERE YEAR(j.datum) = :jahr AND MONTH(j.datum) = :monat GROUP BY j.task.verbuchbar", Verbuchbar.class);
		
		Calendar c = new GregorianCalendar();
		c.setTime(monat);
		
		q.setParameter("jahr", c.get(Calendar.YEAR));
		q.setParameter("monat", c.get(Calendar.MONTH));
		
		return q.getResultList();
	}
}
