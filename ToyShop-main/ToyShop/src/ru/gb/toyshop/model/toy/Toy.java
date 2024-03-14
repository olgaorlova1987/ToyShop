package ru.gb.toyshop.model.toy;

import ru.gb.toyshop.model.toylist.ToyItem;

import java.io.Serializable;

public class Toy implements Serializable, ToyItem {

    private int id;
    private String name;
    private int numberOfToys;
    private int frequency;

    public Toy(String name, int numberOfToys) {
        this.name = name;
        this.numberOfToys = numberOfToys;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfToys() {
        return numberOfToys;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfToys(int numberOfToys) {
        this.numberOfToys = numberOfToys;
    }

    @Override
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "ID:" + id + " Название игрушки: " + name + ", количество: " + numberOfToys + ", частота выпадения: " + frequency;
    }
}
