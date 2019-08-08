import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class Task {
    private String name;
    private String user;
    private Integer time;

    public Task(String name, String user, Integer time) {
        this.name = name;
        this.user = user;
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public Integer getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + "(" + user + ", " + time + ")";
    }

    static void print(List<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.println(list.get(i) + ",");
            }
        }
    }

    static void getInfo(Map<String, List<Task>> map, List<Task> list) {
        for (Map.Entry<String, List<Task>> entry : map.entrySet()) {
            if (entry.getValue() == list)
                print(entry.getValue());
        }
    }

    static Double avgAllTaskCount(Map<String, List<Task>> map) {
        int sum = 0;
        int count =0;
        for (Map.Entry<String, List<Task>> x : map.entrySet()) {
            for (Task y : x.getValue()) {
                sum += y.getTime();
                count++;
            }
        }
        return (double) sum/count;
    }
    static Integer workerCount(Map<String, List<Task>> map, String name) {
        int countName = 0;
        for (Map.Entry<String, List<Task>> x : map.entrySet()) {
            for (Task y : x.getValue()) {
                if (y.getUser().equals((name))) {
                    countName++;
                }
            }
        }
        return countName;
    }

    public static void main(String[] args) {
        List<Task> inProgress = new ArrayList<>();
        inProgress.add(new Task("Deploy to Azure", "Bob", 6));
        inProgress.add(new Task("Handle user input", "John", 5));
        List<Task> toDo = new ArrayList<>();
        toDo.add(new Task("Connect DB", "John", 3));
        toDo.add(new Task("Add users", "Jessica", 2));
        toDo.add(new Task("Confidure logging", "John", 1));
        List<Task> Done = new ArrayList<>();
        Done.add(new Task("Prepare dataset", "Bob", 5));
//        inProgress.add(new Task("Deploy to Azure", "Bob", 6));
//        inProgress.add(new Task("Handle user input","John", 5));
//        toDo.add(new Task("Connect DB","John", 3));
//        toDo.add(new Task("Add users", "Jessica",2));
//        toDo.add(new Task("Confidure logging", "John",1));
//       toDo.add(new Task("Prepare dataset", "Bob",5));

        Map<String, List<Task>> scrum = new LinkedHashMap<>();
        scrum.put("In progress", inProgress);
        scrum.put("To do", toDo);
        scrum.put("Done", Done);
//        scrum.put("Deploy to Azure", inProgress);
//        scrum.put("Handle user input", inProgress);
//        scrum.put("Connect DB", toDo);
//        scrum.put("Add users", toDo);
//        scrum.put("Confidure logging", toDo);
//        scrum.put("Prepare dataset", Done);

        //System.out.println(scrum.toString());
        // Progress
        System.out.println("In Progress " + "(" + inProgress.size() + "):");
        getInfo(scrum, inProgress);
        System.out.println("To do " + "(" + toDo.size() + "):");
        getInfo(scrum, toDo);
        System.out.println("Done " + "(" + Done.size() + "):");
        getInfo(scrum, Done);
//        System.out.println("In Progress "+ "("+ inProgress.size()+"):");
//        for (Map.Entry<String, List<Task>> entry : scrum.entrySet()) {
//            if (entry.getValue() == inProgress)
//                print(entry.getValue());
//
//        }
//        System.out.println();
//        // todo-todo
//        for (Map.Entry<String, List<Task>> entry : scrum.entrySet()) {
//            if (entry.getValue() == toDo){
//                print(entry.getValue());
//            }
//
//        }
//        //Done
//        System.out.println();
//        for (Map.Entry<String, List<Task>> entry : scrum.entrySet()) {
//            if (entry.getValue() == Done)
//                print(entry.getValue());
//        }


//        scrum.entrySet().foreach(x -> {
//            System.out.println(x.getKey() + " (" + x.getValue().size() + ")/r/n");
//            x.getValue().foreach(y -> {
//                System.out.println("* " + y.getName() + " (" + y.getEmployee() + ", " y.getHours() + "/r/n");
//
//            })
//        })
//        final int[] count = new int []{0};
//        final int[] sumHours = new int []{0};
//        map.entrySet().foreach(x -> {
//            sysout(x.getKey() + " (" + x.getValue().size() + ")/r/n");
//            x.getValue().foreach(y -> {
//                sysout("* " + y.getName() + " (" + y.getEmployee() + ", " y.getHours() + "/r/n");
//                if(employee.equals("John")){
//                    count[0] = count[0]++;
//                    sumHours[0] = sumHours[0]++;
//                }
//            })
//        })
//        sysout("John was assigned to " + count[0]);
//        sysout("Average " + count[0]/sumHours[0]);
        System.out.println();
        System.out.println("John was assigned to "+workerCount(scrum,"John") +" takes in this part");
        System.out.printf("Mean approximate time per task is "+ "%.2f",avgAllTaskCount(scrum));
    }
}
