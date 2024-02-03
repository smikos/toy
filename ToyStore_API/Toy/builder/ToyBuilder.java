package ToyStore_API.Toy.builder;

import ToyStore_API.Toy.Toy;

public class ToyBuilder {
    public Toy build(String name, double weight) {
        return new Toy(name, weight);
    }
}
