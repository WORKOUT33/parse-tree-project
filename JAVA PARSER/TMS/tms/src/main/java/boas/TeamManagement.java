package boas;



import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class Team {
    private String teamName;
    private List<Employee> members;

    public Team(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
    }

    public void addMember(Employee employee) {
        members.add(employee);
    }

    public void removeMember(Employee employee) {
        members.remove(employee);
    }

    public void printTeamMembers() {
        System.out.println("Team Members for " + teamName + ":");
        for (Employee member : members) {
            System.out.println(member);
        }
    }
}

public class TeamManagement {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", 1);
        Employee emp2 = new Employee("Alice", 2);
        Employee emp3 = new Employee("Bob", 3);

        Team teamA = new Team("Team A");
        teamA.addMember(emp1);
        teamA.addMember(emp2);

        Team teamB = new Team("Team B");
        teamB.addMember(emp3);

        System.out.println("Initial Teams:");
        teamA.printTeamMembers();
        teamB.printTeamMembers();

        // Move Bob from Team B to Team A
        teamB.removeMember(emp3);
        teamA.addMember(emp3);

        System.out.println("\nTeams after moving Bob from Team B to Team A:");
        teamA.printTeamMembers();
        teamB.printTeamMembers();
    }
}
