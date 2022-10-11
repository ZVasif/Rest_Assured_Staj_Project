package CSP_10.Model;

public class Grade {
    private String id;
    private String name;
    private String shortName;
    private int order;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;

    }

    @Override
    public String toString() {
        return "Grade{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", order=" + order +
                '}';
    }


}
