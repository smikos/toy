package UI.Commands;

import UI.ConsoleUI;

public class Play extends Command{
    public Play(ConsoleUI consoleUI) {
        super("Add a toy to giveaway", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().play();
    }
}
