package edu.tamu.scholars.middleware.discovery.model.repo;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.tamu.scholars.middleware.discovery.model.Person;

import java.util.List;

@RepositoryRestResource
public interface PersonRepo extends SolrDocumentRepo<Person> {

  // throw away method - testing as a proof of concept
  List<Person> findByFirstName(String firstName);

}
