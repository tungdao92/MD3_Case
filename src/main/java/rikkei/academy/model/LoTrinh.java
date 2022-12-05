package rikkei.academy.model;

public class LoTrinh {
    private int id;
    private String name;


    public LoTrinh(String name) {
        this.name = name;
    }


    public LoTrinh( int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

//    @Override
//    public String toString() {
//<<<<<<< HEAD
//        return "Admin{" +
//=======
//        return "LoTrinh{" +
//>>>>>>> tung1
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
    }
