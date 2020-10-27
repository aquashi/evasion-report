package uk.co.fert.repository;

import org.springframework.data.repository.CrudRepository;
import uk.co.fert.dao.Case;


public interface CaseRepository extends CrudRepository<Case, Integer> {

}