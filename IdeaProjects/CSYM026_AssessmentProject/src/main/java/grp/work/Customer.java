package grp.work;

public class Customer {
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name.trim();
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

