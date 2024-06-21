//package ru.andrew.restaurant.service.Impl;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ru.andrew.restaurant.models.Visitor;
//import ru.andrew.restaurant.repository.VisitorRepository;
//import ru.andrew.restaurant.service.VisitorService;
//
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class VisitorServiceImpl implements VisitorService {
//    private final VisitorRepository repository;
//
//
//    @Override
//    public List<Visitor> findAllVisitors() {
//        return repository.findAll();
//    }
//
//    @Override
//    public List<Visitor> findAllServicedVisitors() {
//        return repository.findAll();
//    }
//
//    @Override
//    @Transactional
//    public Visitor addNewVisitor(Visitor visitor) {
//        return null;
//    }
//}
