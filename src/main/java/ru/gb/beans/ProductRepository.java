package ru.gb.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.gb.model.InjectProductTitle;
import ru.gb.model.ItemRepo;
import ru.gb.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("prototype")
@Primary
public class ProductRepository implements ItemRepo {

    private static List<Product> products = new ArrayList<>();

    @InjectProductTitle
    private static void addProductToList(Product product) {
        if (product != null) {
            products.add(product);
        } else {
            System.out.println("Products are not added to the list");
        }
    }

    @PostConstruct
    public void init() {

    }

    @Override
    public Optional<Product> getItem(int id) {
        if (!products.isEmpty()) {
            return Optional.of(products.get(id));
            }
        return Optional.empty();
    }

    @Override
    public void getAllItems() {
        if (!products.isEmpty()) {
            for(Product product : products) {
                System.out.println(product.toString());
            }
        }
    }
}
