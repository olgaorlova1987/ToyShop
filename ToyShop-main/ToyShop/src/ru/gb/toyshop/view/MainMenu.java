package ru.gb.toyshop.view;

import ru.gb.toyshop.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new GetInfo(consoleUI));
        commandList.add(new AddToy(consoleUI));
        commandList.add(new DeleteToy(consoleUI));
        commandList.add(new ChangeNumberOfToys(consoleUI));
        commandList.add(new ResultList(consoleUI));
        commandList.add(new ViewResult(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1).append(". ").append(commandList.get(i).getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}

