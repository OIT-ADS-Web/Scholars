package edu.tamu.scholars.middleware.discovery.model.repo;

import org.springframework.stereotype.Repository;

import edu.tamu.scholars.middleware.discovery.model.Process;

@Repository
public interface ProcessRepo extends SolrDocumentRepo<Process> {

}
