
import edu.duke.*;
import org.apache.commons.csv.*;

public class example1 {
    public void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record: parser){
            System.out.println(record);
            System.out.println(record.get("Name"));
            System.out.println(record.get("Favorite Food"));
        }
    }
}
