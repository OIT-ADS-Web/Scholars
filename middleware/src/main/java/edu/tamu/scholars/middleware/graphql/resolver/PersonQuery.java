package edu.tamu.scholars.middleware.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.tamu.scholars.middleware.discovery.model.Person;
import edu.tamu.scholars.middleware.discovery.model.repo.PersonRepo;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;

@Component
public class PersonQuery implements GraphQLQueryResolver {

  @Autowired
  private PersonRepo personRepo;

  public List<Person> listPersons() {
    return personRepo.findByType("FacultyMember");
  }

}

