package UI.Commands;

import UI.ConsoleUI;

public class GetPrizeToysInfo extends Command{
    public GetPrizeToysInfo(ConsoleUI consoleUI) {
        super("Get list of prize toys", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().getPrizeToysInfo();
    }
}
