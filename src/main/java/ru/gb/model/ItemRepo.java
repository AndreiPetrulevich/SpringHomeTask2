package ru.gb.model;

import java.util.Optional;

public interface ItemRepo {
    Optional<Product> getItem(int id);
    void getAllItems();
}
