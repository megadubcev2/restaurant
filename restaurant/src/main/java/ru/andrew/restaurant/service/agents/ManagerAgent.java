package ru.andrew.restaurant.service.agents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import ru.andrew.restaurant.repository.RestaurantRepositoryInMemory;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ManagerAgent {
    private RestaurantRepositoryInMemory repository;



    final private VisitorsAgent visitorsAgent;
    final private Logout logout;


    public ManagerAgent() throws IOException {

        visitorsAgent = new VisitorsAgent(this);
        logout = new Logout(servicedVisitorsFilePath);




    }

    public void action() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectReader reader = objectMapper.readerForListOf(Visitor.class);

            List<Visitor> newVisitors = reader.readValue(Paths.get(newVisitorsFilePath).toFile());
            visitorsAgent.setNewVisitors(newVisitors);
            visitorsAgent.action();

        } catch (IOException e) {
            logError(e);
        }
    }

    public void logServicedVisitors(List<Visitor> servicedVisitors) throws IOException {
        logout.logServicedVisitors(servicedVisitors);
    }

    public void logError(Exception e){
        logout.logError(e);
    }
}
