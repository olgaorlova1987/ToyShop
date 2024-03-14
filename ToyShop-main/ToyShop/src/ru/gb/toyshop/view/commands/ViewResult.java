package ru.gb.toyshop.view.commands;

import ru.gb.toyshop.view.ConsoleUI;

public class ViewResult extends Command {
    public ViewResult(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать результат розыгрыша";
    }

    public void execute() {
        consoleUI.viewResultList();
    }
}
