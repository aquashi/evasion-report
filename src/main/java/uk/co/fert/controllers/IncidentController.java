package uk.co.fert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.fert.dao.Incident;
import uk.co.fert.services.IncidentService;

import java.util.List;

@Controller
public class IncidentController {
    @Autowired
    IncidentService incidentService;

    @GetMapping("/findIncident")
    @Secured({"ROLE_STATION", "ROLE_REVENUE"})
    @ResponseBody
    public Incident findIncident(@RequestParam(name = "id") int id) {
        return incidentService.findIncident(id);
    }

    @GetMapping("/findAllIncidentsByStationId")
    @Secured({"ROLE_STATION", "ROLE_REVENUE"})
    @ResponseBody
    public List<Incident> findAllIncidentsByStationId(@RequestParam(name = "id") int id) {
        return incidentService.findAllIncidentsByStationId(id);
    }

    @PostMapping("/createIncident")
    @Secured({"ROLE_ADMIN", "ROLE_STATION"})
    @ResponseBody
    public String create(@RequestBody Incident incident) {
        incidentService.save(incident);
        return "redirect:/incident";
    }

    @PatchMapping("/editIncident")
    @Secured("ROLE_STATION")
    @ResponseBody
    public String edit(@RequestBody Incident incident) {
        incidentService.save(incident);
        return "redirect:/incident";
    }
}
