package country;

import MaxValue.ReadAndWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Country> countries=new ArrayList<>();
    public static void readCountryFromFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while((line=bufferedReader.readLine())!=null){
            String countryLine[]=line.split(",");
            String countryId=countryLine[0];
            String countryCode=countryLine[1];
            String countryName=countryLine[2];
            Country country=new Country(countryId,countryCode,countryName);
            countries.add(country);
        }
        bufferedReader.close();
        fileReader.close();
    }
    public static void writeCountryList(String path) throws IOException {
        FileWriter fileWriter=new FileWriter(path);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        for(int i=0;i<countries.size();i++)
        {
            bufferedWriter.write(countries.get(i).toString());
            if(i!=countries.size()-1)
            {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        readCountryFromFile("C:\\Users\\Admin\\IdeaProjects\\IO\\apj-read-csv-file\\countries.csv");
        writeCountryList("C:\\Users\\Admin\\IdeaProjects\\IO\\apj-read-csv-file\\countries.csv");
    }
    private static void printCountry(List<String> country) {
        ReadAndWriteFile rd=new ReadAndWriteFile();
        List<Integer> countries=rd.readFile("C:\\Users\\Admin\\IdeaProjects\\IO\\apj-read-csv-file\\countries.csv");
        for(Integer i:countries)
        {
            System.out.println(i);
        }
    }
}
