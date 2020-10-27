package uk.co.fert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.fert.dao.Case;
import uk.co.fert.services.CaseService;

@Controller

public class CaseController {
    @Autowired
    CaseService caseService;

    @PostMapping("/createCase")
    @Secured("ROLE_STATION")
    @ResponseBody
    public void create(@RequestBody Case c) {
        caseService.save(c);
    }

    @PatchMapping("/editCase")
    @Secured({"ROLE_STATION", "ROLE_REVENUE"})
    @ResponseBody
    public void edit(@RequestBody Case c) {
        caseService.save(c);
    }

    @GetMapping("/findCase")
    @Secured({"ROLE_STATION", "ROLE_REVENUE"})
    @ResponseBody
    public Case find(@RequestParam(name = "id") int id) {
        return caseService.find(id);
    }
}
