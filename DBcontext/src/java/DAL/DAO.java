
package DAL;

import Model.Department;
import Model.Student;
import java.sql.*;
import java.util.*;

public class DAO {
    private ArrayList<Student> stdList;
    private HashMap<String,Department> departHm;
    private String status;
    private Connection con;

    public ArrayList<Student> getStdList() {
        return stdList;
    }

    public void setStdList(ArrayList<Student> stdList) {
        this.stdList = stdList;
    }

    public HashMap<String, Department> getDepartHm() {
        return departHm;
    }

    public void setDepartHm(HashMap<String, Department> departHm) {
        this.departHm = departHm;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public DAO(){
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
            status = "Error connection"+e.getMessage();
        }
    }
    
    public void loadStudent(){
        stdList = new ArrayList<Student>();
        String sql = "Select * from Student";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String id = rs.getString(1);
                String name = rs.getString(2);
                String deptId = rs.getString(3);
                boolean gender = rs.getBoolean(4);
                float GPA = rs.getFloat(5);
                String address = rs.getString(6);
                stdList.add(new Student(id, name, deptId, gender, GPA, address));
            }
        } catch (Exception e) {
                status = "Error connection"+e.getMessage();
        }
    }
    
    public void loadDepart(){
        String sql = "Select * from Department";
        departHm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String id = rs.getString(1);
                String name = rs.getString(2);
                String infor = rs.getString(3);
                departHm.put(id, new Department(id, name, infor));
            }
        } catch (Exception e) {
            status = "Error department"+e.getMessage();
        }
    }

    public void Insert(String id, String name, String departId, boolean gender, float gpa, String add) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
