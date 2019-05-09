package edu.tamu.scholars.middleware.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.tamu.scholars.middleware.discovery.model.Person;
import edu.tamu.scholars.middleware.discovery.model.repo.PersonRepo;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@Component
public class PersonQuery implements GraphQLQueryResolver {

  @Autowired
  private PersonRepo personRepo;

  public List<Person> searchPeople(String query) {
    Pageable pageable = PageRequest.of(0,10);
    Page<Person> personPage = personRepo.findByCustomQuery(query, pageable);
    return personPage.getContent();
  }

}

