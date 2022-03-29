package ru.gb.model;

public interface ItemMuteRep {
    ItemRep getItemRep();
    void setItemRep(ItemRep itemRep);
    void deleteItem(int id);
    void addItem(int id);
}
