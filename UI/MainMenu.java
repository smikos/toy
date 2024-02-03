package UI;

import UI.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        this.commands = new ArrayList<>();
        commands.add(new AddToy(consoleUI));
        commands.add(new EditToyWeight(consoleUI));
        commands.add(new GetToyStoreInfo(consoleUI));
        commands.add(new GetPrizeToysInfo(consoleUI));
        commands.add(new Play(consoleUI));
        commands.add(new GetPrize(consoleUI));
        commands.add(new CheckPrize(consoleUI));
        commands.add(new Exit(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1)
                    .append(".")
                    .append(" ")
                    .append(commands.get(i).getDescription())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public int getSize() {
        return commands.size();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }
}
