package ru.andrew.restaurant.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.andrew.restaurant.models.Visitor;
import ru.andrew.restaurant.service.VisitorService;


import java.util.List;


@RestController
@RequestMapping("/api/v1/visitors")
@AllArgsConstructor
public class VisitorController {
    private final VisitorService service;

    @GetMapping
    public List<Visitor> findServicedVisitors() {
        return service.findServicedVisitors();
    }

    @PostMapping("add_visitor")
    public String addNewVisitor(@RequestBody Visitor visitor) {
        service.addNewVisitor(visitor);
        return "Visitor successfully saved";
    }

}
