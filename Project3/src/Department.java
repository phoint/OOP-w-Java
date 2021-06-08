import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String departmentID;
    private String departmentName;
    private final List<Staff> staffInDepartment = new ArrayList<>();
    private int departmentTotalEmployee;

    public Department(String departmentName) {
        if (departmentName.length() > 3) {
            this.departmentID = departmentName.substring(0, 3);
        } else {
            this.departmentID = departmentName;
        }
        this.departmentName = departmentName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentTotalEmployee() {
        return departmentTotalEmployee;
    }

    public List<Staff> getStaffInDepartment() {
        return staffInDepartment;
    }


    public void addStafftoDepartment(Staff member) {
        this.staffInDepartment.add(member);
        this.departmentTotalEmployee++;
    }

    public void removeStaffFromDepartment(Staff member) {
        this.staffInDepartment.remove(member);
        this.departmentTotalEmployee--;
    }

    @Override
    public String toString() {
        return "Ma bo phan: " + departmentID + "\n" +
                "Bo phan: " + departmentName + "\n" +
                "Tong so nhan vien: " + departmentTotalEmployee;
    }
}
