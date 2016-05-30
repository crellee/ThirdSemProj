package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kristinOlof on 03-05-2016.
 */
public class Employee
{
    private String name;
    private int id;

    public Employee()
    {}

    public Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }
}
