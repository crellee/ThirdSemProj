package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathalie on 03-05-2016.
 */
public class Point
{
    private int point;
    private boolean active;

    public static List<Point> pointList = new ArrayList<Point>();

    public Point()
    {}

    public Point(int point, boolean active)
    {
        this.point = point;
        this.active = active;
    }

    public int getPoint()
    {
        return point;
    }

    public void setPoint(int point)
    {
        this.point = point;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }
}
