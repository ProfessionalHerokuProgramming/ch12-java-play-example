package models;

import play.db.ebean.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Employee extends Model {

    @Id
    public Long id;
    
    public String name;
    
    public String email;

    public static Finder<Long,Employee> find = new Finder(
        Long.class, Employee.class
    );

    public Employee(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static List<Employee> all() {
      return Employee.find.all();
    }

    public static Integer count() {
      return Employee.find.all().size();
    }
}