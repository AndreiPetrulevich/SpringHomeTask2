package ru.gb.model;

public interface ItemMuteRepo {
    ItemRepo getItemRep();
    void setItemRep(ItemRepo itemRep);
    void deleteItem(int id);
    void addItem(int id);
}
