package ru.andrew.restaurant.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.andrew.restaurant.models.Visitor;
import ru.andrew.restaurant.repository.RestaurantRepositoryInMemory;
import ru.andrew.restaurant.service.VisitorService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class VisitorServiceInMemoryIml implements VisitorService {
    private final RestaurantRepositoryInMemory repository;


    @Override
    public List<Visitor> findServicedVisitors() {
        return repository.findServicedVisitors();
    }

    @Override
    public Visitor addNewVisitor(Visitor visitor) {
        return repository.addNewVisitor(visitor);
    }
}
