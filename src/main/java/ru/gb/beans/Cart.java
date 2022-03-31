package ru.gb.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.model.ItemMuteRepo;
import ru.gb.model.ItemRepo;
import ru.gb.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("cart")
@Scope("prototype")
public class Cart implements ItemMuteRepo {

    private ItemRepo itemRep;

    Map<Integer, Optional<Product>> items = new HashMap<>();

    @Autowired
    public Cart(ItemRepo itemRep) {
        this.itemRep = itemRep;
    }

    @Override
    public ItemRepo getItemRep() {
        return this.itemRep;
    }

    @Override
    public void setItemRep(ItemRepo itemRep) {
        this.itemRep = itemRep;
    }

    @Override
    public void deleteItem(int id) {
        if (!items.containsKey(id)) {
            return;
        }
        items.remove(id);
    }

    @Override
    public void addItem(int id) {
        items.put(id,itemRep.getItem(id));
    }
}
