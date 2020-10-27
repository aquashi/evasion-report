package uk.co.fert.services;

import uk.co.fert.dao.Case;

public interface CaseService {
    void save(Case c);

    Case find(int id);
}
