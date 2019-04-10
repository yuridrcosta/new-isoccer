package isoccer;

import java.util.ArrayList;

public class EmployeeIterator implements Iterator {

    private ArrayList<Employee> employees;
    private int position = 0;

    public EmployeeIterator(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    @Override
    public boolean hasNext() {
        return position+1 <= employees.size();
    }

    @Override
    public Employee next() {
        Employee nextEmployee = employees.get(position);
        position++;
        return nextEmployee;
    }
    
}
