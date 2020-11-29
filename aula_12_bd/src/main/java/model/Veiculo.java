package model;

import org.bson.types.ObjectId;

public class Veiculo {
    private ObjectId id;
    private String placa;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo() {

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                '}';
    }
}
