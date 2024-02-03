package ToyStore_API.Toy;

import java.io.Serializable;

public class Toy implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(String name, double weight) {
        this.id = -1;
        this.name = name;
        this.quantity = 1;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nID: ")
                .append(id)
                .append("\n")
                .append("Name: ")
                .append(name)
                .append("\n")
                .append("Quantity: ")
                .append(quantity)
                .append("\n")
                .append("Weight: ")
                .append(weight);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Toy toy)){
            return false;
        }
        return toy.getName().equals(getName()) && toy.getWeight() == getWeight();
    }
}
