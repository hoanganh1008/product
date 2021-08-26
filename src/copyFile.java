import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copyFile {
    public static void main(String[] args) throws IOException {

            FileReader fileReader=new FileReader("C:\\Users\\Admin\\IdeaProjects\\IO\\src\\sourcefile");


            FileWriter fileWriter=new FileWriter("C:\\Users\\Admin\\IdeaProjects\\IO\\src\\MaxValue\\targetFile");

        int copy=0;
        while((copy=fileReader.read())!=-1)
        {
            fileWriter.write(copy);
        }
        fileReader.close();
        fileWriter.close();
    }
}
