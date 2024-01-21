package part3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    private List<Guitar> guitars;

    public Inventory()
    {
        guitars = new ArrayList<>();
    }
    public void addGuitar(Guitar guitar)
    {
        guitars.add(guitar);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("guitars_database.txt", true)))
        {
            writer.write(guitarToString(guitar));
            writer.newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //had to add a toString to put it in the .txt file
    private String guitarToString(Guitar guitar)
    {
        return guitar.getSerialNumber() + "," +
                guitar.getPrice() + "," +
                guitar.getBuilder() + "," +
                guitar.getModel() + "," +
                guitar.getType() + "," +
                guitar.getBackWood() + "," +
                guitar.getTopWood();
    }

    public Guitar getGuitar(String serialNumber)
    {
        for (Guitar guitar : guitars)
        {
            if (guitar.getSerialNumber().equals(serialNumber))
                return guitar;
        }
        return null;
    }

    public Guitar search(Guitar g)
    {
        for(int i = 0; i < guitars.size(); i++)
        {
            if(guitars.get(i) == g)
                return(guitars.get(i));
        }
        return(null);
    }

}
