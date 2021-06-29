package repositories;

import entities.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonRepository {

    public Person findPersonById(Integer id){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        return em.find(Person.class, id);
    }

    public List<Person> getAllPersons(){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        List<Person> persons = em.createQuery("Select b From Person b").getResultList();
        return persons;
    }


    public void createPerson (Person person){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public void updatePerson(Person person){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void deletePerson(Person person){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        Person foundPerson = em.find(Person.class, person.getId());
        em.remove(foundPerson);
        em.getTransaction().commit();
    }
}
