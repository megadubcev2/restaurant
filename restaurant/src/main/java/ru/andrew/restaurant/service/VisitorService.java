package ru.andrew.restaurant.service;

import ru.andrew.restaurant.models.Visitor;

import java.util.List;

public interface VisitorService {
    List<Visitor> findServicedVisitors();
    Visitor addNewVisitor(Visitor visitor);
}
