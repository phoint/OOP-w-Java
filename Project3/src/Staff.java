public abstract class Staff {

    abstract void displayInformation();

    public String getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public double getCoefficientSalary() {
        return coefficientSalary;
    }

    public String getStartDate() {
        return startDate;
    }

    public Department getDepartment() {
        return department;
    }

    public int getNumberOfDayOff() {
        return numberOfDayOff;
    }

    private String staffID;
    private String name;
    private int yearsOld;
    private double coefficientSalary;
    private String startDate;
    private Department department;
    private int numberOfDayOff;
    protected long totalSalary;

    public long getTotalSalary() {
        return totalSalary;
    }

    public abstract void setTotalSalary(double coefficientSalary, int basicSalary, int responsiveSalary, int overTime);

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void setCoefficientSalary(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setDepartment(Department department) {
        assert department != null;
        this.department = department;
        this.department.addStafftoDepartment(this);
    }

    public void setNumberOfDayOff(int numberOfDayOff) {
        this.numberOfDayOff = numberOfDayOff;
    }

}
