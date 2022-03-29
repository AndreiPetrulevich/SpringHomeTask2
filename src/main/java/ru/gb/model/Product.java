package ru.gb.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private int id;
    private String title;
    private String cost;

    @Override
    public String toString() {
        return "ID: " + this.getId() + ", Title: " + this.getTitle() + ", Cost: " + this.getCost();
    }
}
