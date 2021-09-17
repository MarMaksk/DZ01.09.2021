package task3;

public class UserId {
    private int id;

    public UserId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id" + id;
    }
}
