package ru.gb.toyshop.view.commands;

import ru.gb.toyshop.view.ConsoleUI;

public class GetInfo extends Command{
    public GetInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Просмотреть игрушки в файле";
    }

    public void execute(){
        consoleUI.getInfo();
    }

}
