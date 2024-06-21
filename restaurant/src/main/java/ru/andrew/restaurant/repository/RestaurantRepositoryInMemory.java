package ru.andrew.restaurant.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.stereotype.Repository;
import ru.andrew.restaurant.models.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class RestaurantRepositoryInMemory {
    final private List<MenuDish> menuDishes;
    final private List<DishCard> dishCards;
    final private List<ProductType> productTypes;
    final private List<ProductItem> productItems;
    final private List<OperationType> operationTypes;
    final private List<Equipment> equipments;
    final private List<EquipmentType> equipmentTypes;
    final private List<Cooker> cookers;
    final private List<Visitor> newVisitors;
    final private List<Visitor> servicedVisitors;




    public RestaurantRepositoryInMemory(List<Visitor> newVisitors) throws IOException {

        File menuDishesFile= new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "input" + File.separator + "menu_dishes.json");
        File dishCardsFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "input" + File.separator + "dish_cards.json");
        File productTypesFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "input" + File.separator + "product_types.json");
        File productItemsFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "input" + File.separator + "product_items.json");
        File operationTypesFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "input" + File.separator + "operation_types.json");
        File equipmentsFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "input" + File.separator + "equipments.json");
        File equipmentTypesFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "input" + File.separator + "equipment_types.json");
        File cookersFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "input" + File.separator + "cookers.json");
        File newVisitorsFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + File.separator + "input" + File.separator + "new_visitors.json");
        File servicedVisitorsFile = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "jsons" + File.separator + "output" + File.separator + "serviced_visitors.json");

        ObjectMapper objectMapper = new ObjectMapper();

        ObjectReader reader = objectMapper.readerForListOf(MenuDish.class);
        this.menuDishes = reader.readValue(menuDishesFile);

        reader = objectMapper.readerForListOf(DishCard.class);
        this.dishCards =  reader.readValue(dishCardsFile);

        reader = objectMapper.readerForListOf(ProductType.class);
        this.productTypes =  reader.readValue(productTypesFile);

        reader = objectMapper.readerForListOf(ProductItem.class);
        this.productItems =  reader.readValue(productItemsFile);

        reader = objectMapper.readerForListOf(OperationType.class);
        this.operationTypes =  reader.readValue(operationTypesFile);

        reader = objectMapper.readerForListOf(Equipment.class);
        this.equipments =  reader.readValue(equipmentsFile);

        reader = objectMapper.readerForListOf(EquipmentType.class);
        this.equipmentTypes =  reader.readValue(equipmentTypesFile);

        reader = objectMapper.readerForListOf(Cooker.class);
        this.cookers =  reader.readValue(cookersFile);

        reader = objectMapper.readerForListOf(Visitor.class);
        this.newVisitors = reader.readValue(newVisitorsFile);

        this.servicedVisitors = new ArrayList<Visitor>();


    }

    public List<Visitor> findServicedVisitors() {
        return servicedVisitors;
    }
    public List<Visitor> findNewVisitors() {
        return newVisitors;
    }

    public synchronized Visitor addNewVisitor(Visitor visitor){
        newVisitors.add(visitor);
        return visitor;
    }

    public synchronized Visitor addServicedVisitor(Visitor visitor){
        servicedVisitors.add(visitor);
        return visitor;
    }

    public synchronized Visitor removeNewVisitor(Visitor visitor){
        Visitor removedVisitor = null;
        Iterator<Visitor> iterator = newVisitors.iterator();
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            if (v.getVisName().equals(visitor.getVisName())) {
                removedVisitor = v;
                iterator.remove();
                break; // Остановить цикл после удаления первого совпавшего элемента
            }
        }
        return removedVisitor;
    }

}
