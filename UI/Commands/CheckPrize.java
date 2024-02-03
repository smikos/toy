package UI.Commands;

import UI.ConsoleUI;

public class CheckPrize extends Command {
    public CheckPrize(ConsoleUI consoleUI) {
        super("Check your prize information", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().checkPrize();
    }
}
