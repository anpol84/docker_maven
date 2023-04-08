package org.example.components.empolyee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class MyEmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public MyEmployeeRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public Iterable<Employee> filter(String name, String phone, String email, Double salary, String position){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Predicate predicate = criteriaBuilder.conjunction();
        if (name!= null && !name.isEmpty()){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(employeeRoot.get("name"), name));
        }
        if (phone != null && !phone.isEmpty()){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(employeeRoot.get("phone"), phone));
        }
        if (email != null && !email.isEmpty()){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(employeeRoot.get("email"), email));
        }
        if (salary != null){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(employeeRoot.get("salary"), salary));
        }
        if (position != null && !position.isEmpty()){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(employeeRoot.get("position"), position));
        }


        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
