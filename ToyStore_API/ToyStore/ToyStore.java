package ToyStore_API.ToyStore;

import ToyStore_API.Toy.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore implements Serializable{
    private List<Toy> toys;
    private List<Toy> prizes;
    private List<Toy> prizeToys;
    private Random random;

    public ToyStore() {
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
        this.prizes = new ArrayList<>();
        this.random = new Random();
    }

    public void adder(List<Toy> toys, Toy toy) {
        if (toy != null) {
            if (!toys.contains(toy)) {
                toys.add(toy);
                toy.setId(toys.size());
            } else {
                Toy oldToy = toys.get(toys.indexOf(toy));
                oldToy.setQuantity(oldToy.getQuantity() + 1);
            }
        }
    }

    public void addToy(Toy toy) {
        adder(toys, toy);
    }

    private void addPrizeToy(Toy toy) {
        adder(prizeToys, toy);
    }

    public void editToyWeight(int id, double weight) {
        for (Toy toy:
             toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy play() {
        double totalWeight = 0;
        for (Toy toy:
             toys) {
            totalWeight += toy.getWeight();
        }
        double randomWeight = random.nextDouble() * totalWeight;
        double weightSum = 0;
        for (Toy toy:
             toys) {
            weightSum += toy.getWeight();
            if (randomWeight <= weightSum) {
                Toy prizeToy = new Toy(toy.getName(), toy.getWeight());
                addPrizeToy(prizeToy);
                toy.setQuantity(toy.getQuantity() - 1);
                if (toy.getQuantity() == 0) {
                    toys.remove(toy);
                }
                return prizeToy;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo(toys);
    }

    public List<Toy> getToys() {
        return toys;
    }

    public List<Toy> getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            int index = random.nextInt(prizeToys.size());
            Toy prizeToy = prizeToys.get(index);
            Toy prize = new Toy(prizeToy.getName(), prizeToy.getWeight());
            adder(prizes, prize);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
            if (prizeToy.getQuantity() == 0) {
                prizeToys.remove(index);
            }
            return prizes;
        }
        return null;
    }

    public String getInfo(List<Toy> toys) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There is (are) ")
                .append(toys.size())
                .append(" toy(s) in the list:\n");
        for (Toy toy:
                toys) {
            stringBuilder.append(toy)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public String getPrizeToysInfo() {
        return getInfo(prizeToys);
    }

    public String getPrizesInfo() {
        return getInfo(prizes);
    }
}