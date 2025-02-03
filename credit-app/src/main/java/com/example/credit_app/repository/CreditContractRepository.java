// package com.example.credit_app.repository;

// import com.example.credit_app.entity.CreditContract;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface CreditContractRepository extends JpaRepository<CreditContract, Long> {
//     List<CreditContract> findBysigningStatus(boolean signingStatus);
// }

package com.example.credit_app.repository;

import com.example.credit_app.entity.CreditContract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class CreditContractRepository {
    private final SessionFactory sessionFactory;

    public CreditContractRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<CreditContract> findBySigningStatus(boolean signingStatus) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM CreditContract WHERE signingStatus = :status", CreditContract.class)
                    .setParameter("status", signingStatus)
                    .list();
        }
    }

    public void save(CreditContract contract) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(contract);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public CreditContract findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(CreditContract.class, id);
        }
    }

    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            CreditContract contract = session.get(CreditContract.class, id);
            if (contract != null) {
                session.remove(contract);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
