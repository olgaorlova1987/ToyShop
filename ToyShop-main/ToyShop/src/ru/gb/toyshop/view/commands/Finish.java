package ru.gb.toyshop.view.commands;

import ru.gb.toyshop.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход";
    }

    public void execute() {
        consoleUI.finish();
    }
}
