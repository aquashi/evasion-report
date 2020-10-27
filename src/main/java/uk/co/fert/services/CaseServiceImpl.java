package uk.co.fert.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.fert.dao.Case;
import uk.co.fert.repository.CaseRepository;

@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    private CaseRepository caseRepository;

    @Override
    public void save(Case c) {
        this.caseRepository.save(c);
    }

    @Override
    public Case find(int id) {
        return caseRepository.findById(id).orElse(new Case());
    }
}