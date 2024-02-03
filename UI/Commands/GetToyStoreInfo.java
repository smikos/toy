package UI.Commands;

import UI.ConsoleUI;

public class GetToyStoreInfo extends Command{
    public GetToyStoreInfo(ConsoleUI consoleUI) {
        super("Get toy store info", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().getToyStoreInfo();
    }
}
