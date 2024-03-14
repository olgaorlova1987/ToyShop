package ru.gb.toyshop.view;

import ru.gb.toyshop.model.writer.Writable;
import ru.gb.toyshop.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        hello();
        load();
        while (work) {
            printMenu();
            choice();
        }
    }

    private void hello() {
        System.out.println("Добро пожаловать!");
    }

    private void choice() {
        String value = scanner.nextLine();
        if (checkMenu(value)) {
            int num = Integer.parseInt(value);
            menu.execute(num);
        }
    }

    private boolean checkMenu(String text) {
        try {
            if (Integer.parseInt(text) > 0 && Integer.parseInt(text) <= menu.getSize()) {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Вы ввели неверное значение!");
        return false;
    }

    public void finish() {
        System.out.println("Работа приложения завершена.");
        scanner.close();
        work = false;
    }

    private void printMenu() {
        System.out.println("Выберите пункт меню.");
        System.out.println(menu.menu());
    }

    public void resultList() {
        try {
            if (presenter.resultList()) {
                success();
            } else {
                error();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void addToy() {
        System.out.println("Введите название игрушки: ");
        String name = scanner.nextLine();
        System.out.println("Введите количество: ");
        int numberOfToys = checkInt();
        presenter.addToy(name, numberOfToys);
        if (presenter.save()) {
            success();
        } else {
            error();
        }
    }

    private int checkInt() {
        int value = 0;
        boolean i = true;
        while (i) {
            String text = scanner.nextLine();
            if (text.matches("[0-9]+")) {
                value = Integer.parseInt(text);
                i = false;
            } else {
                System.out.println("Неверное значение! Введите целое число.");
            }
        }
        return value;
    }

    public void deleteToy() {
        System.out.println("Введите Id игрушки, которую нужно удалить из списка: ");
        int id = checkInt();
        if (presenter.deleteToy(id)) {
            success();
        } else {
            error();
        }
    }

    private void success() {
        System.out.println("Данные сохранены.");
    }

    private void error() {
        System.out.println("Данные не записаны!");
    }

    public void getInfo() {
        if (!presenter.getInfo()) {
            System.out.println("Список пуст! Добавьте игрушки в файл.");
        }
    }

    public void load() {
        try {
            presenter.load();
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeNumberOfToys() {
        System.out.println("Введите Id игрушки для изменения количества: ");
        int id = checkInt();
        System.out.println("Введите новое количество игрушек: ");
        int numberOfToys = checkInt();
        presenter.changeNumberOfToys(id, numberOfToys);
        if (presenter.save()) {
            success();
        } else {
            error();
        }
    }

    public void viewResultList() {
        if (!presenter.viewResultList()) {
            System.out.println("Список пуст!");
        }
    }

    public void setWritable(Writable writable) {
        presenter.setWritable(writable);
    }
}
