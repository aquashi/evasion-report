package uk.co.fert.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "case")
public class Case {
    @Id
    @Column(name = "case_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    private List<Incident> incidents = new ArrayList<Incident>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return getId().equals(aCase.getId()) &&
                getIncidents().equals(aCase.getIncidents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIncidents());
    }
}