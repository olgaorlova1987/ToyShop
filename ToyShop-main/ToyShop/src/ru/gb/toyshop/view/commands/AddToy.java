package ru.gb.toyshop.view.commands;

import ru.gb.toyshop.view.ConsoleUI;

public class AddToy extends Command {
    public AddToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить игрушку";
    }

    public void execute() {
        consoleUI.addToy();
    }
}