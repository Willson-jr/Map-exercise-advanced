import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.get;

@AllArgsConstructor
@Data

public class Employee {
    private Integer id;
    private Integer salary;
    private String job;

    @Override
    public String toString() {
        return "(" + id + ")" + "(" + job + "): " + salary;
    }


    public static void main(String[] args) {
        List<Employee> workers = new ArrayList<>();

        workers.add(new Employee(1, 12000, "Programmer"));
        workers.add(new Employee(2, 6500, "Secretraty"));
        workers.add(new Employee(3, 13500, "Programmer"));
        workers.add(new Employee(4, 6000, "Programmer"));
        workers.add(new Employee(5, 8000, "Programmer"));

        for (Employee worker : workers) {
            System.out.println(worker.toString());
        }

        System.out.println("Mean annual salary for programmers is: " + annualProg(workers));
        List<Integer> listInt = moreThan(workers,7000);
        System.out.print("Employees who earn more than 7k: ");
        for (int i = 0; i < listInt.size(); i++) {
            if (i == listInt.size()-1) {
                System.out.print(listInt.get(i));
            } else {
                System.out.print(listInt.get(i) + ",");
            }
        }


    }

    public static Float annualProg(List<Employee> list) {
        float sum = 0;
        int count = 0;
        for (Employee employee : list) {
            if (employee.getJob().equals("Programmer")) {
                sum += (float) employee.getSalary();
                count++;
            }
        }
        return sum / count * 12;
    }

    public static List<Integer> moreThan (List<Employee> list, Integer line){
        List<Integer> earnIdList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() > line){
                earnIdList.add(employee.getId());
            }
        }
        return earnIdList;
    }
}



