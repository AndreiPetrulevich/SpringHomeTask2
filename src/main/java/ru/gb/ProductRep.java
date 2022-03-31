package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.model.ItemRepo;
import ru.gb.model.ProductConfiguration;


public class ProductRep {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfiguration.class);
        ItemRepo repository = context.getBean(ItemRepo.class);
        repository.getItem(1);
        repository.getAllItems();
    }
}
