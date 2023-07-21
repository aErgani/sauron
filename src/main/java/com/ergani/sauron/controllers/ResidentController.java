package com.ergani.sauron.controllers;

import com.ergani.sauron.domain.Resident;
import com.ergani.sauron.enums.Role;
import com.ergani.sauron.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/resident")
public class ResidentController {
    @Autowired
    private ResidentRepository residentRepository;

    @PostMapping(path="/create") // Map ONLY POST Requests
    public @ResponseBody String addNewResident (@RequestParam String name
            , @RequestParam String trid
            , @RequestParam Role role) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Resident resident = new Resident();
        resident.setName(name);
        resident.setTrid(trid);
        resident.setRole(role);
        residentRepository.save(resident);
        return "Saved";
    }

    @GetMapping(path="/getAll")
    public @ResponseBody Iterable<Resident> getAllResidents() {
        // This returns a JSON or XML with the users
        return residentRepository.findAll();
    }

    @GetMapping(path="/getById")
    public @ResponseBody Optional<Resident> getResidentById(long id) {
        // This returns a JSON or XML with the users
        return residentRepository.findById(id);
    }

    @GetMapping(path="/getByTrid")
    public @ResponseBody Optional<Resident> getResidentByTrid(String trid) {
        // This returns a JSON or XML with the users
        return residentRepository.findByTrid(trid);
    }
}
