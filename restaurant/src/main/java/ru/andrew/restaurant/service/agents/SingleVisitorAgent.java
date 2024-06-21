package ru.andrew.restaurant.service.agents;

import ru.andrew.restaurant.models.Visitor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SingleVisitorAgent extends Thread {
    private final Visitor visitor;
    private final VisitorsAgent visitorsAgent;
    private final ManagerAgent managerAgent;

    public SingleVisitorAgent(Visitor visitor, VisitorsAgent visitorsAgent, ManagerAgent managerAgent) {
        this.visitorsAgent = visitorsAgent;
        this.managerAgent = managerAgent;
        this.visitor = visitor;
        visitor.setVisStarted(new Date());

        double visTotal = 0;
        for (var dish :
                visitor.getVisDishes()) {
            visTotal += dish.getMenuDishPrice();
        }
        visitor.setVisTotal(visTotal);
    }

    @Override
    public void run() {
        try {
            for (var dish :
            visitor.getVisDishes()) {
                TimeUnit.SECONDS.sleep(4);
            }
            visitor.setVisEnded(new Date());
            visitor.setIsEnded(true);

            visitorsAgent.addServicedVisitor(visitor);

        } catch (InterruptedException e) {
            managerAgent.logError(e);
            Thread.currentThread().interrupt();
        }
    }

    public void action() {
        start();
    }
}
