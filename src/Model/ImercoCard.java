package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathalie on 03-05-2016.
 */
public class ImercoCard
{
    private int cardId;
    private int activePoints;

    public static List<Receipt> receiptListList = new ArrayList<Receipt>();
    public static List<Point> pointList = new ArrayList<Point>();

    public ImercoCard()
    {}

    public ImercoCard(int cardId, int activePoints)
    {
        this.cardId = cardId;
        this.activePoints = activePoints;


    }

    public int getCardId()
    {
        return cardId;
    }

    public void setCardId(int cardId)
    {
        this.cardId = cardId;
    }

    public int getActivePoints()
    {
        return activePoints;
    }

    public void setActivePoints(int activePoints)
    {
        this.activePoints = activePoints;
    }
}
