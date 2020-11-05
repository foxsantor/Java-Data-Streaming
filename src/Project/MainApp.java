package Project;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


public class MainApp {
    //file must be put inside the project directory
    private static long sumOfSuicideCases = 0;
    private static long sumOfThePopulation = 0;
    private static float percentage = 0;
    private final static String FILE_PATH = System.getProperty("user.dir") + "/whosuicidestatistics.csv";

    public static void main(String[] args) throws IOException {
        File csvFile = new File(FILE_PATH);
        if (!csvFile.exists()) {
            throw new IllegalStateException("File does not Exist");
        }
        /*NOTE:Basic Implementation without mapping the data
         *skip(0) used to skip the first line (label line) of the file as it does not contain any Data */
        //*****************Display Data for females suicide cases*****************
        //Files.lines(csvFile.toPath()).skip(0).filter(line->line.contains("female")).forEach(System.out::println);
        //*****************Display Data for males from Albania suicide cases*****************
        //Files.lines(csvFile.toPath()).skip(0).filter(line->line.contains("male") && line.contains("Albania")).forEach(System.out::println);

        /* Advanced implementation using opencsv*/
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(SuicideData.class);
        //fixing the Columns
        String[] columns = new String[]{"country", "year", "gender", "ageRange", "suicideNumbers", "population"};
        strategy.setColumnMapping(columns);
        //Creating our instance to handle the mapping
        CsvToBean beanToMap = new CsvToBean();
        //File calling
        CSVReader csvReader = new CSVReader(new FileReader(FILE_PATH));
        //Mapping the DATA
        List<SuicideData> data = beanToMap.parse(strategy, csvReader);
        //removing the label line
        data.remove(0);
        //System.out.println(data);

        //*****************get the number of all entries inside of the file*****************
        //System.out.println("this file contains: "+data.stream().count()+" entries of data");
        //*****************get all Females entries*****************
        // data.stream().filter(d -> d.getGender().equals("female")).forEach(System.out::println);
        //*****************get all the male over the age of 75*****************
        //data.stream().filter(d -> d.getGender().equals("male") && d.getAgeRange().equals("75+ years")).forEach(System.out::println);
        //*****************get the entry of the highest number of suicide cases the filter is used to skip the missing or unknown data within the file*****************
        //System.out.println(data.stream().filter(entry->!entry.getSuicideNumbers().equals("")).max(Comparator.comparing(item->Long.parseLong(item.getSuicideNumbers()))).orElseThrow(NoSuchElementException::new));
        //*****************get the min suicide cases of females aging between 15-24 within the year 2010*****************
        //System.out.println(data.stream().filter(entry->entry.getGender().equals("female") && entry.getAgeRange().contains("15-24") && entry.getYear().equals("2010") && !entry.getSuicideNumbers().equals("")).min(Comparator.comparing(item->Long.parseLong(item.getSuicideNumbers()))));
        //*****************get the sum of the suicide cases for Russia*****************
        /*data.stream().filter(entry ->!entry.getSuicideNumbers().equals("") && entry.getCountry().equals("Russian Federation")).forEach(element-> sumOfSuicideCases += Long.parseLong(element.getSuicideNumbers()));
        System.out.println(sumOfSuicideCases+" cases of suicide :( may they rest in peace");*/
        //*****************get the percentage of the people that died from suicide in the year of 2009*****************
        /*data.stream().filter(entry->!entry.getSuicideNumbers().equals("") && !entry.getPopulation().equals("") && entry.getYear().equals("2009")).forEach(element->{
            sumOfSuicideCases += Long.parseLong(element.getSuicideNumbers());
            sumOfThePopulation +=  Long.parseLong(element.getPopulation());
        });
        percentage = ((float)sumOfSuicideCases * 100)/(float)sumOfThePopulation;
        System.out.println(String.format("%.3f",percentage) +"% has committed suicide during 2009 out of "+sumOfThePopulation+" people from all ages.");
        */
        //*****************get the percentage of the people that died from suicide for each entry*****************
        /*data.stream().filter(entry->!entry.getSuicideNumbers().equals("") && !entry.getPopulation().equals("")).forEach(element->{
            sumOfSuicideCases = Long.parseLong(element.getSuicideNumbers());
            sumOfThePopulation =  Long.parseLong(element.getPopulation());
            percentage = (float)(sumOfSuicideCases*100)/(float)sumOfThePopulation;
            System.out.println(element.toString()+" around "+String.format("%.3f",percentage)+"%");
        });*/
    }
}
