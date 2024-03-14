package ru.gb.toyshop.view.commands;

import ru.gb.toyshop.view.ConsoleUI;

public class DeleteToy extends Command {
    public DeleteToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить игрушку";
    }

    public void execute() {
        consoleUI.deleteToy();
    }
}