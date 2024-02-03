package UI.Commands;

import UI.ConsoleUI;

public class EditToyWeight extends Command{
    public EditToyWeight(ConsoleUI consoleUI) {
        super("Edit toys' weight", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().editToyWeight();
    }
}
