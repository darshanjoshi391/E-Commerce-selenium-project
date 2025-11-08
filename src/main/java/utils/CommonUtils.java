package utils;


import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
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

    public static boolean compareTwoscreenshots(String actualImagePath, String expectedImagePath) throws IOException {
        BufferedImage acutualBImg = ImageIO.read (new File(actualImagePath));
        BufferedImage expectedBImg = ImageIO.read (new File(expectedImagePath));

        ImageDiffer imgDiffer = new ImageDiffer();
        ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, acutualBImg);

        return imgDifference.hasDiff();

    }



}
