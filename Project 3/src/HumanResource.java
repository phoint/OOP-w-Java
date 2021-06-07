import java.util.*;

public class HumanResource {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mainTaskOption;
        ArrayList<Staff> staffArrayList = new ArrayList<>();
        Set<Department> departmentArraySet = new HashSet<>();
        Department departmentForThisStaff;
        ArrayList<String> titleName = new ArrayList<>();
        titleName.add("Business Leader");
        titleName.add("Project Leader");
        titleName.add("Technical Leader");
//        boolean isContinue;

        /* Main loop
         * Start the loop for execute task
         * User choose the option match the task
         * Every option has a method below this main */
        do {
            mainTaskOption = welcome(sc);
            while (mainTaskOption == 1) {
                System.out.print("Bo phan cong ty: ");
                String departmentNameInput = sc.next();
                departmentForThisStaff = departmentArraySet.stream().filter(d -> departmentNameInput
                        .equalsIgnoreCase(d.getDepartmentName())).findFirst().orElse(new Department(departmentNameInput));
                departmentArraySet.add(departmentForThisStaff);
                staffArrayList.add(addNew(titleName, departmentForThisStaff, sc));
                System.out.print("Them nhan vien khac (Y/N)? ");
                if (!sc.next().equalsIgnoreCase("Y")) {
                    mainTaskOption = -1;
                }
            }

            while (mainTaskOption == 2) {
                System.out.println("Danh sach nhan vien Cong ty");
                showStaffList(staffArrayList);
                System.out.println("----------------------------");
                do {
                    System.out.print("Quay lai (Y/N): ");
                } while (!sc.next().equalsIgnoreCase("Y"));
                mainTaskOption = -1;
            }

            while (mainTaskOption == 3) {
                System.out.println("Danh sach bo phan Cong ty");
                showDepartmentList(departmentArraySet);
                System.out.println("----------------------------");
                do {
                    System.out.print("Quay lai (Y/N): ");
                } while (!sc.next().equalsIgnoreCase("Y"));
                mainTaskOption = -1;
            }

            while (mainTaskOption == 4) {
                Staff memberFound = findStaff(staffArrayList, sc);
                if (memberFound == null) {
                    System.out.println("Khong tim thay nhan vien.");
                } else {
                    System.out.println("Da tim thay nhan vien");
                    memberFound.displayInformation();
                }
                System.out.println("---------------------------");
                System.out.print("Tiep tuc tim (Y/N)? ");
                if (!sc.next().equalsIgnoreCase("Y")) {
                    mainTaskOption = -1;
                }
            }

            while (mainTaskOption == 5) {
                System.out.println("Bang luong nhan vien theo thu tu tang dan");
                showSalarySheet(staffArrayList);
                System.out.println("----------------------------");
                do {
                    System.out.print("Quay lai (Y/N): ");
                } while (!sc.next().equalsIgnoreCase("Y"));
                mainTaskOption = -1;
            }

            while (mainTaskOption == 6) {
                System.out.println("Bang luong nhan vien theo thu tu giam dan");
                showSalarySheetReverse(staffArrayList);
                System.out.println("----------------------------");
                do {
                    System.out.print("Quay lai (Y/N): ");
                } while (!sc.next().equalsIgnoreCase("Y"));
                mainTaskOption = -1;
            }

            while (mainTaskOption == 7) {
                System.out.println("Hien thi nhan vien theo danh sach tung bo phan");
                showStaffFromDepartment(departmentArraySet);
                System.out.println("----------------------------");
                do {
                    System.out.print("Quay lai (Y/N): ");
                } while (!sc.next().equalsIgnoreCase("Y"));
                mainTaskOption = -1;
            }

//            System.out.println("Ban co muon tiep tuc tac vu khac khong (Y/N)? ");
//            if (sc.next().equalsIgnoreCase("Y")) {
//                isContinue = true;
//            } else {
//                System.out.println("Xin chao & hen gap lai!");
//                isContinue = false;
//            }
        } while (mainTaskOption != 8); // End main loop
    }

    /* Create a new Employee Object. Set status with user's input information
     * Employee has a Department Object. setDepartmentName by user's input. departmentID is auto-generated */
    public static Employee addNewEmployee(Department department, Scanner sc) {
        Employee member = new Employee();
        member.setDepartment(department);
        System.out.print("Ma Nhan Vien: ");
        member.setStaffID(sc.next());
        sc.nextLine();
        System.out.print("Ten Nhan Vien: ");
        member.setName(sc.nextLine());
        System.out.print("Tuoi: ");
        member.setYearsOld(sc.nextInt());
        System.out.print("He So Luong: ");
        member.setCoefficientSalary(sc.nextDouble());
        System.out.print("Ngay Bat Dau Lam Viec: ");
        member.setStartDate(sc.next());
        System.out.print("So Ngay Phep Hang Nam: ");
        member.setNumberOfDayOff(sc.nextInt());
        System.out.print("So Gio Lam Them: ");
        member.setOvertimeHours(sc.nextInt());
        member.setTotalSalary(member.getCoefficientSalary(), member.getBasicSalary(), 0, member.getOvertimeHours());
        return member;
    }

    /* Create a new Manager Object. Set status with user's input information
     * Manager has a Department Object. setDepartmentName by user's input. departmentID is auto-generated */
    public static Manager addNewManager(ArrayList<String> title, Department department, Scanner sc) {
        Manager manager = new Manager();
        manager.setDepartment(department);
        System.out.print("Ma Nhan Vien: ");
        manager.setStaffID(sc.next());
        sc.nextLine();
        System.out.print("Ten Nhan Vien: ");
        manager.setName(sc.nextLine());
        System.out.print("Tuoi: ");
        manager.setYearsOld(sc.nextInt());
        System.out.print("Chuc Danh: ");
        sc.nextLine();
        String titleName = sc.nextLine();

        // Ask user type the right title for this manager
        // This title match the right responsibility salary for calculate total salary further
        while (!title.contains(titleName)) {
            System.out.println("Khong co chuc vu nay trong Cong ty");
            System.out.println("Vui long nhap 1 trong 3 chuc danh nay:");
            System.out.println("Business Leader, Project Leader, Technical Leader");
            titleName = sc.nextLine();
        }
        int responsiveSalary;
        if (titleName.equalsIgnoreCase("Business Leader")) {
            responsiveSalary = 8000000;
        } else if (titleName.equalsIgnoreCase("Project Leader")) {
            responsiveSalary = 5000000;
        } else {
            responsiveSalary = 6000000;
        }
        manager.setTitleName(titleName);
        System.out.print("He So Luong: ");
        manager.setCoefficientSalary(sc.nextDouble());
        System.out.print("Ngay Bat Dau Lam Viec: ");
        manager.setStartDate(sc.next());
        System.out.print("So Ngay Phep Hang Nam: ");
        manager.setNumberOfDayOff(sc.nextInt());
        manager.setTotalSalary(manager.getCoefficientSalary(), manager.getBasicSalary(), responsiveSalary, 0);
        return manager;
    }

    /* Show the welcome and menu of task
     * User must type a number from 1 to 7 for specific task
     * 8 to exit
     * If the input is not match any item, program will ask for another input */
    public static int welcome(Scanner sc) {
        System.out.println("Chao mung ban den voi he thong quan ly nhan vien!");
        System.out.println("1. Them Moi Nhan Vien");
        System.out.println("2. Hien Thi Danh Sach Nhan Vien");
        System.out.println("3. Hien Thi Cac Bo Phan");
        System.out.println("4. Tim Kiem Nhan Vien");
        System.out.println("5. Sap xep Bang luong nhan vien (tang dan)");
        System.out.println("6. Sap xep bang luong nhan vien (giam dan)");
        System.out.println("7. Hien thi nhan vien trong tung bo phan");
        System.out.println("8. Thoat");
        System.out.print("Vui long chon so tuong ung voi tac vu: ");
        int maintask = 0;
        if (sc.hasNextInt()) {
            maintask = sc.nextInt();
        } else {
            sc.next();
        }
        while (maintask != 1 && maintask != 2 && maintask != 3 &&
                maintask != 4 && maintask != 5 && maintask != 6 && maintask != 7 && maintask != 8) {
            System.out.print("Khong co task vu tuong ung, vui long nhap lai: ");
            if (sc.hasNextInt()) {
                maintask = sc.nextInt();
            } else {
                sc.next();
            }
        }
        return maintask;
    }

    /* This happen before addNewEmployee & addNewManager method
     * User choose which kind of staff will be add to Company (Employee or Manager)
     * These two object have some difference which ask difference add method */
    public static Staff addNew(ArrayList<String> title, Department department, Scanner sc) {
        System.out.println("Ban muon them moi: ");
        System.out.println("1. Nhan Vien");
        System.out.println("2. Quan Ly");
        System.out.print("Vui long nhap so tuong ung cau tra loi (1 hoac 2): ");
        int addNewOption = 0;
        Staff member;
        if (sc.hasNextInt()) {
            addNewOption = sc.nextInt();
        } else {
            sc.next();
        }
        while (addNewOption != 1 && addNewOption != 2) {
            System.out.print("Khong co tuy chon nao cho dap an nay. Vui long nhap lai (1 hoac 2) ");
            if (sc.hasNextInt()) {
                addNewOption = sc.nextInt();
            } else {
                sc.next();
            }
        }
        if (addNewOption == 1) {
            member = addNewEmployee(department, sc);
        } else {
            member = addNewManager(title, department, sc);
        }
        return member;
    }

    /* This happen after add new member to company
     * This will show a list of staff (Employee & Manager) on screen */
    public static void showStaffList(ArrayList<Staff> staffArrayList) {
        for (Staff member : staffArrayList) {
            System.out.println("------------------------");
            if (member instanceof Employee) {
                System.out.println("Cap Bac Nhan Vien");
            } else {
                System.out.println("Cap Bac Quan Ly");
            }
            member.displayInformation();

        }
    }

    /* This show a list of Department on screen
     * No duplicate */
    public static void showDepartmentList(Set<Department> departmentSet) {
        for (Department department : departmentSet) {
            System.out.println("----------------------------");
            System.out.println(department);
        }
    }

    /* This method looking in List of Staff, checking if a member is in the List
     * User choose a key to compare (name or id)  */
    public static Staff findStaff(ArrayList<Staff> staffArrayList, Scanner sc) {
        System.out.println("Ban muon tim kiem nhan vien theo: ");
        System.out.println("1. Ten");
        System.out.println("2. Ma nhan vien");
        int optionFinder = sc.nextInt();
        while (optionFinder != 1 && optionFinder != 2) {
            System.out.print("Cau tra loi khong dung dinh dang, vui long nhap lai: ");
            optionFinder = sc.nextInt();
        }

        if (optionFinder == 1) {
            System.out.print("Ten nhan vien can tim: ");
            sc.nextLine();
            String nameFinder = sc.nextLine();
            return staffArrayList.stream().filter(staff -> nameFinder.equalsIgnoreCase(staff.getName())).findFirst().orElse(null);
        } else {
            System.out.println("Ma nhan vien: ");
            sc.nextLine();
            String idFinder = sc.nextLine();
            return staffArrayList.stream().filter(staff -> idFinder.equalsIgnoreCase(staff.getStaffID())).findFirst().orElse(null);
        }
    }

    /* This method display a list of Staff sorted by salary from min to max */
    public static void showSalarySheet(ArrayList<Staff> staffArrayList) {
        staffArrayList.stream().sorted(Comparator.comparingLong(Staff::getTotalSalary)).forEach(Staff::displayInformation);
    }

    /* This method display a list of Staff sorted by salary from max to min */
    public static void showSalarySheetReverse(ArrayList<Staff> staffArrayList) {
        staffArrayList.stream().sorted(Comparator.comparingLong(Staff::getTotalSalary).reversed()).forEach(Staff::displayInformation);
    }

    /* This method display list of Staff grouped by Department */
    public static void showStaffFromDepartment(Set<Department> departments) {
        for (Department dept : departments) {
            System.out.println("-----------------------------");
            System.out.println("Nhan vien bo phan: " + dept.getDepartmentName());
            for (Staff staff : dept.getStaffInDepartment()) {
                staff.displayInformation();
                System.out.println("-----------------------------");
            }
        }
    }
}
