package ru.gb.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.gb.model.InjectProductTitle;
import ru.gb.model.ItemRep;
import ru.gb.model.Product;
import java.util.List;

@Component
@Primary
public class ProductRepository implements ItemRep {

    private static List<Product> products;

    @InjectProductTitle
    private static void addProductToList(Product product) {
        if (product != null) {
            products.add(product);
        } else {
            System.out.println("Products are not added to the list");
        }
    }

    @Override
    public Product getItem(int id) {

        if (!products.isEmpty()) {
            for(Product product : products) {
                if (product.getId() == id) {
                    System.out.println(product.toString());
                    return product;
                }
            }
        }
        return null;
    }

    @Override
    public void getAllItems() {
        if (!products.isEmpty()) {
            for(Product product : products) {
                System.out.println(product.toString());;
            }
        }
    }
}
