package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Person;
import java.util.List;

public interface PersonDao  {


  public void add(Person person);

  public int delete(int no);

  public List<Person> findAll();

  public Person findBy(int no);

  public int update(Person person);

  public Person findByEmailAndPassword(String email, String password);

}
