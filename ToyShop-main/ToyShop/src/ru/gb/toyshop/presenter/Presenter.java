package ru.gb.toyshop.presenter;

import ru.gb.toyshop.model.Service;
import ru.gb.toyshop.model.writer.Writable;
import ru.gb.toyshop.view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public boolean resultList() throws IOException {
        if (!service.resultList().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean save() {
        return service.save();
    }

    public void addToy(String name, int numberOfToys) {
        view.printAnswer(service.addToy(name, numberOfToys));
    }

    public boolean deleteToy(int id) {
        return service.deleteToy(id);
    }

    public boolean getInfo() {
        if (!service.getInfo().isEmpty()){
            view.printAnswer(service.getInfo());
            return true;
        }
        return false;
    }

    public void changeNumberOfToys(int id, int numberOfToys) {
        view.printAnswer(service.changeNumberOfToys(id, numberOfToys));
    }

    public void load() throws IOException {
        service.load();
    }

    public boolean viewResultList() {
        if (service.viewResultList() != null) {
            view.printAnswer(service.viewResultList());
            return true;
        }
        return false;
    }

    public void setWritable(Writable writable) {
        service.setWritable(writable);
    }
}
