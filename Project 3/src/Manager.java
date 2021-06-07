public class Manager extends Staff implements ICalculator {
    private String titleName;
    private int basicSalary = 5000000;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public void setTotalSalary(double coefficient, int basicSalary, int responsibility, int overTime) {
        this.totalSalary = this.calculateSalary(coefficient, basicSalary, responsibility, 0);
    }

    @Override
    void displayInformation() {
        System.out.println("Ma Nhan Vien: " + this.getStaffID());
        System.out.println("Ten Nhan Vien: " + this.getName());
        System.out.println("Tuoi: " + this.getYearsOld());
        System.out.println("Chuc Danh: " + this.getTitleName());
        System.out.println("He So Luong: " + this.getCoefficientSalary());
        System.out.println("Ngay Vao Lam: " + this.getStartDate());
        System.out.println("Bo Phan Lam Viec: " + this.getDepartment().getDepartmentName());
        System.out.println("So Ngay Phep Hang Nam: " + this.getNumberOfDayOff());
        System.out.println("Luong: ");
        System.out.format("%,d%n", this.getTotalSalary());
    }

    @Override
    public long calculateSalary(double coefficientSalary, int basicSalary, int responsibilitySalary, int overTime) {
        return (long) (coefficientSalary * basicSalary + responsibilitySalary + overTime * 200000L);
    }
}
