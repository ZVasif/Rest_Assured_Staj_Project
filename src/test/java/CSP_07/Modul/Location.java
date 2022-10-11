package CSP_07.Modul;

public class Location {
    private String id;
    private String name;
    private String shortName;
    private int capacity;
    private String schoolID;

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", capacity='" + capacity + '\'' +
                ", schoolID='" + schoolID + '\'' +
                '}';
    }
}



//  "id": null,
//  "name": "{{$randomFullName}}",
//  "shortName": "{{$randomUserName}}",
//  "active": true,
//  "capacity": "{{$randomInt}}",
//  "type": "CLASS",
//  "school": {
//    "id": "5fe07e4fb064ca29931236a5"
//  }