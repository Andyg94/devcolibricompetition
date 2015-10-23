package ua.com.prologistic.devcompetition.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Andrew on 23.10.2015.
 */
public class DateGenerator {

    // переменные для минимальной и максимальной дат
    private long startTime;
    private long endTime;

    public DateGenerator(){
        // инициализируем переменные
        setUp();
    }

    // получаем рандомную дату
    public Date getRandomDate(){
        return new Date(generateRandomValue());
    }

    // задаем минимальную и максимальную дату,
    // между которыми будет генерироваться рандомная дата
    private void setUp() {
        startTime = Timestamp.valueOf("2010-01-01 00:00:00").getTime();
        endTime = Timestamp.valueOf("2015-12-31 00:58:00").getTime();
    }

    // получаем время для рандомной даты
    private long generateRandomValue () {
        long randNum = endTime - startTime + 1;
        return startTime + (long) (Math.random() * randNum);
    }
}
