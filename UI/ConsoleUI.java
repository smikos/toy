package UI;

import Presenter.Presenter;
import ToyStore_API.Toy.Toy;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean action;
    private MainMenu mainMenu;

    public ConsoleUI() {
        this.presenter = new Presenter(this);
        this.scanner = new Scanner(System.in);
        this.action = true;
        this.mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Welcome!");
        while (action) {
            printMenu();
            choice();
        }
    }

    public void printMenu() {
        System.out.println(mainMenu.menu());
    }

    public void addToy() {
        System.out.println("Input toys' name: ");
        String name = scanner.nextLine();
        System.out.println("Input toys' weight (1-10): ");
        double weight = Double.parseDouble(scanner.nextLine());
        presenter.addToy(name, weight);
    }

    public void editToyWeight() {
        System.out.println("Input toys' id: ");
        int id = Integer.parseInt(scanner.nextLine());
        double newWeight = 0;
        if (id > presenter.getToys().size() || id < 1) {
            System.out.println("There is no toy with this id");
        } else {
            for (Toy toy:
                    presenter.getToys()) {
                if (id == toy.getId()) {
                    System.out.println("Input toys' new weight (1 - 10): ");
                    newWeight = Double.parseDouble(scanner.nextLine());
                    presenter.editToyWeight(id, newWeight);
                }
            }
        }
    }


    public void play() {
        boolean option = true;
        while (option) {
            Toy prizeToy = presenter.play();
            if (prizeToy != null && !presenter.getToys().isEmpty()) {
                System.out.println("Added");
                System.out.println("Add one more toy for giveaway? (y/n)");
                String answer = scanner.nextLine();
                if (answer.equals("n")){
                    option = false;
                } else if (!answer.equals("y")) {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("Out of toys");
                option = false;
            }
        }
    }

    public void getPrizeToy() {
        List<Toy> prizes = presenter.getPrizeToy();
        if (prizes != null) {
            System.out.println("Congratulations! You have won a new toy");
            presenter.save(presenter.getPrizesInfo(), "Prizes.txt");
        } else {
            System.out.println("Out of prizes");
        }
    }


    public void getToyStoreInfo() {
        presenter.getToyStoreInfo();
    }

    public void getPrizeToysInfo() {
        presenter.getPrizeToysInfo();
    }

    public void checkPrize() {
        System.out.println(presenter.getPrizesInfo());
    }

    private void choice() {
        String choiceStr = scanner.nextLine();
        try {
            int choice = Integer.parseInt(choiceStr);
            if (choice < 1 || choice > mainMenu.getSize()){
                error();
            } else {
                mainMenu.execute(choice);
            }
        } catch (NumberFormatException e) {
            error();
        }
    }

    public void finish() {
        System.out.println("Exiting...");
        action = false;
    }

    private void error(){
        System.out.println("Pick one of the available options(pick the number)");
    }

    @Override
    public void printAnswer(String message) {
        System.out.println(message);
    }
}
