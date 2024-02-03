package UI.Commands;

import UI.ConsoleUI;

public class AddToy extends Command{
    public AddToy(ConsoleUI consoleUI) {
        super("Add new toy", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().addToy();
    }
}
