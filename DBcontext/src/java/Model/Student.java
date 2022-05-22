
package Model;

public class Student {
    private String Id;
    private String name;
    private String deptId;
    private boolean gender;
    private float GPA;
    private String address;

    public Student() {
    }
    
    public Student(String Id, String name, String deptId, boolean gender, float GPA, String address) {
        this.Id = Id;
        this.name = name;
        this.deptId = deptId;
        this.gender = gender;
        this.GPA = GPA;
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toRow(){
        String s = "<tr>";
        s+="<td>"+Id+"</td>";
        s+="<td>"+name+"</td>";
        s+="<td>"+deptId+"</td>";
        s+="<td>"+(gender?"Male":"Female")+"</td>";
        s+="<td>"+GPA+"</td>";
        s+="<td>"+address+"</td>";
        s+="</tr>";
        return s;
    }
    public String toRow(String departName){
        String s = "<tr>";
        s+="<td>"+Id+"</td>";
        s+="<td>"+name+"</td>";
        s+="<td>"+deptId+"</td>";
        s+="<td>"+departName +"</td>";
        s+="<td>"+(gender?"Male":"Female")+"</td>";
        s+="<td>"+GPA+"</td>";
        s+="<td>"+address+"</td>";
        s+="</tr>";
        return s;
    }
}
