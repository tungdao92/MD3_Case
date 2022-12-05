package rikkei.academy.model;

public class Module {
    private int id;
    private int id_lotrinh;
    String name_module;

    public Module() {
    }

    public Module(int id, int id_lotrinh, String name) {
        this.id = id;
        this.id_lotrinh = id_lotrinh;
        this.name_module = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_lotrinh() {
        return id_lotrinh;
    }

    public void setId_lotrinh(int id_lotrinh) {
        this.id_lotrinh = id_lotrinh;
    }

    public String getName_module() {
        return name_module;
    }

    public void setName_module(String name_module) {
        this.name_module = name_module;
    }
}
