package utils;

import java.util.Date;

public class CommonUtils
{
    public static String GenerateEmail ()
    {
        Date date = new Date();
        String dateString = date.toString();
        String dateStringWithoutSpace = dateString.replaceAll("\\s", "");
        String dateStringwithoutcolon = dateStringWithoutSpace.replaceAll("\\:", "");
        String brandnewEmail = dateStringwithoutcolon + "@gmail.com";
        return brandnewEmail;
    }

}
