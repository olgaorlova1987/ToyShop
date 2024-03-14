package ru.gb.toyshop.view.commands;

import ru.gb.toyshop.view.ConsoleUI;

public class ResultList extends Command {
    public ResultList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сформировать список розыгрыша";
    }

    public void execute() {
        consoleUI.resultList();
    }
}