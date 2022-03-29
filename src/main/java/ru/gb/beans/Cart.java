package ru.gb.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.gb.model.ItemMuteRep;
import ru.gb.model.ItemRep;
import ru.gb.model.Product;

import java.util.Map;

@Component
@Profile("cart")
public class Cart implements ItemMuteRep{

    private ItemRep itemRep;

    Map<Integer, Product> items;

    @Autowired
    public Cart(ItemRep itemRep) {
        this.itemRep = itemRep;
    }

    @Override
    public ItemRep getItemRep() {
        return this.itemRep;
    }

    @Override
    public void setItemRep(ItemRep itemRep) {
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
        items.put(id, itemRep.getItem(id));
    }
}
