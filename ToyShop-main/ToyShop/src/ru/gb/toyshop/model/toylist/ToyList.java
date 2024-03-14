package ru.gb.toyshop.model.toylist;

import ru.gb.toyshop.model.toy.Toy;
import ru.gb.toyshop.model.toy.ToyComparator;

import java.io.Serializable;
import java.util.*;

public class ToyList<E extends ToyItem> implements Serializable, Iterable<E>{

    private List<E> toyList;
    private int toyId;
    private int total;

    public ToyList() {
        toyList = new ArrayList<>();
    }

    public void addToy(E toy) {
        toy.setId(toyId++);
        toyList.add(toy);
    }

    public List<E> getToyList() {
        return toyList;
    }

    public List<Toy> resultList(ToyList toyList) {
        List<Toy> result = new ArrayList<>();
        Queue<Toy> priorityList = new PriorityQueue<>(new ToyComparator<>());
        priorityList.addAll(toyList.getToyList());
        while (toyList.getTotal() >= 1) {
            Toy choice = priorityList.peek();
            result.add(choice);
            choice.setNumberOfToys(choice.getNumberOfToys() - 1);
            toyList.setFrequences(toyList.getTotal() - 1);
            priorityList.remove(choice);
            priorityList.add(choice);
        }
        return result;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setFrequences(int total) {
        setTotal(total);
        if (total != 0) {
            for (E toy: toyList) {
                toy.setFrequency(toy.getNumberOfToys()*100/getTotal());
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ToyIterator<>(toyList);
    }

    public Toy findInList(int id) {
        for (E toy : toyList) {
            if (toy.getId() == id) {
                return (Toy) toy;
            }
        }
        return null;
    }
    public void deleteToy(int id) {
        toyList.removeIf(toy -> toy.getId() == id);
        int newTotal = 0;
        for (E toy : toyList) {
            newTotal += toy.getNumberOfToys();
        }
        setFrequences(newTotal);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (E toy : toyList) {
            sb.append(toy).append("\n");
        }
        return sb.toString();
    }
}
