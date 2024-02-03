package UI.Commands;

import UI.ConsoleUI;

public class GetPrize extends Command{
    public GetPrize(ConsoleUI consoleUI) {
        super("Get the prize", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().getPrizeToy();
    }
}
