package rikkei.academy.model;

public class BaiDoc {
    private int id;
//<<<<<<< HEAD
//    private String name;
//
//    public BaiDoc(String name) {
//        this.name = name;
//    }
//
//    public BaiDoc(int id, String name) {
//        this.id = id;
//        this.name = name;
//=======
    private int id_lotrinh;
    private int id_module;
    String name_baidoc;

    public BaiDoc() {
    }

    public BaiDoc(int id, int id_lotrinh, int id_module, String name_baidoc) {
        this.id = id;
        this.id_lotrinh = id_lotrinh;
        this.id_module = id_module;
        this.name_baidoc = name_baidoc;
//>>>>>>> tung1
    }

    public BaiDoc(String name) {

    }

    public BaiDoc(int id, String name) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//<<<<<<< HEAD
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "BaiDoc{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//=======
    public int getId_lotrinh() {
        return id_lotrinh;
    }

    public void setId_lotrinh(int id_lotrinh) {
        this.id_lotrinh = id_lotrinh;
    }

    public int getId_module() {
        return id_module;
    }

    public void setId_module(int id_module) {
        this.id_module = id_module;
    }

    public String getName_baidoc() {
        return name_baidoc;
    }

    public void setName_baidoc(String name_baidoc) {
        this.name_baidoc = name_baidoc;
//>>>>>>> tung1
    }
}
