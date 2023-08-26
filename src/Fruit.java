class Fruit {
    String id, name, origin;
    double price;
    int quantity;

    public Fruit() {
    }

    public Fruit(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }   
    
    public Fruit(String id, String name, String origin, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
