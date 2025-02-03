// package com.example.credit_app.repository;

// import com.example.credit_app.entity.CreditApplication;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;

// @Repository
// public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
//         List<CreditApplication> findByPhoneNumberOrFirstNameOrLastNameOrPassportNumber(
//             String phoneNumber, String firstName, String lastName, String passportNumber);

//         List<CreditApplication> findByApprovedTrue();
// }


package com.example.credit_app.repository;

import com.example.credit_app.entity.CreditApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Transaction;
import java.util.List;

public class CreditApplicationRepository {
    private final SessionFactory sessionFactory;

    public CreditApplicationRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<CreditApplication> findByPhoneNumberOrFirstNameOrLastNameOrPassportNumber(
            String phoneNumber, String firstName, String lastName, String passportNumber) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                            "FROM CreditApplication WHERE phoneNumber = :phone OR firstName = :first OR lastName = :last OR passportNumber = :passport",
                            CreditApplication.class)
                    .setParameter("phone", phoneNumber)
                    .setParameter("first", firstName)
                    .setParameter("last", lastName)
                    .setParameter("passport", passportNumber)
                    .list();
        }
    }

    public List<CreditApplication> findByApprovedTrue() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM CreditApplication WHERE approved = true", CreditApplication.class).list();
        }
    }

    public void save(CreditApplication application) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(application);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public CreditApplication findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(CreditApplication.class, id);
        }
    }

    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            CreditApplication application = session.get(CreditApplication.class, id);
            if (application != null) {
                session.remove(application);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<CreditApplication> findAllApplications() {
        try (Session session = sessionFactory.openSession()) {
            Query<CreditApplication> query = session.createQuery("FROM CreditApplication", CreditApplication.class);
            return query.list();
        }
    }
}
