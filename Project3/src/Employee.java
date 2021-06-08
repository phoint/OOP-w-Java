public class Employee extends Staff implements ICalculator {
    private int basicSalary = 3000000;
    private int overtimeHours;

    @Override
    void displayInformation() {
        System.out.println("Ma Nhan Vien: " + this.getStaffID());
        System.out.println("Ten Nhan Vien: " + this.getName());
        System.out.println("Tuoi: " + this.getYearsOld());
        System.out.println("He So Luong: " + this.getCoefficientSalary());
        System.out.println("Ngay Vao Lam: " + this.getStartDate());
        System.out.println("Bo Phan Lam Viec: " + this.getDepartment().getDepartmentName());
        System.out.println("So Ngay Phep Hang Nam: " + this.getNumberOfDayOff());
        System.out.println("So Gio Lam Them: " + this.getOvertimeHours());
        System.out.println("Luong: ");
        System.out.format("%,d%n", this.getTotalSalary());
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public void setTotalSalary(double coefficent, int basicSalary, int responsiveSalary, int overtime) {
        this.totalSalary = this.calculateSalary(coefficent, basicSalary, 0, overtime);
    }

    @Override
    public long calculateSalary(double coefficientSalary, int basicSalary, int responsibilitySalary, int overTime) {
        return (long) (coefficientSalary * basicSalary + overTime * 200000L + responsibilitySalary);
    }
}
