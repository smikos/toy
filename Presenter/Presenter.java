package Presenter;

import ToyStore_API.Service.Service;
import ToyStore_API.Toy.Toy;
import UI.View;

import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public void getToyStoreInfo() {
        view.printAnswer(service.getToyStoreInfo());
    }

    public void addToy(String name, double weight) {
        service.addToy(name, weight);
        getToyStoreInfo();
    }

    public void editToyWeight(int id, double weight) {
        service.editToyWeight(id, weight);
        getToyStoreInfo();
    }

    public Toy play() {
        return service.play();
    }

    public List<Toy> getToys() {
        return service.getToys();
    }

    public List<Toy> getPrizeToy() {
        return service.getPrizeToy();
    }

    public String getPrizesInfo() {
        return service.getPrizesInfo();
    }

    public void getPrizeToysInfo() {
        view.printAnswer(service.getPrizeToysInfo());
    }

    public boolean save(String s, String fileName) {
        return service.save(s, fileName);
    }
}
