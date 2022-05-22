package Model;

public class Department {
    private String id;
    private String name;
    private String infor;

    public Department() {
    }

    public Department(String id, String name, String infor) {
        this.id = id;
        this.name = name;
        this.infor = infor;
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

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }
    
}
