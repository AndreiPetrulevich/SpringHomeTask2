package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.model.ItemRep;
import ru.gb.model.ProductConfiguration;


public class ProductRep {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfiguration.class);
        ItemRep repository = context.getBean(ItemRep.class);
        repository.getItem(1);
        repository.getAllItems();
    }
}
