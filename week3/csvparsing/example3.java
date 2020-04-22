import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class example3 {
    public double getColdestInDay(CSVParser parser){
        double cold = 100.00;
        String dateutc = "";
        for(CSVRecord record: parser){
            double temp = Double.parseDouble(record.get("TemperatureF"));
            if((temp<cold) && (temp>0)){
                cold = temp;
                dateutc = record.get("DateUTC");
            }
        }
        //System.out.println("Coldest temp in day: "+cold);
        //System.out.println("Coldest temp in day hour: "+dateutc);
        return cold;
    }
    
    public void printColdestInDayTime(CSVParser parser1, CSVParser parser2){
        double coldest = getColdestInDay(parser1);
        for(CSVRecord record: parser2){
            if((Double.parseDouble(record.get("TemperatureF"))) == coldest){
                System.out.println(record.get("DateUTC"));
            }
        }
    }
    
    public void filesWithColdestTemp(){
        double temp = 100;
        String filename = "";
        DirectoryResource dir = new DirectoryResource();
        for(File fr: dir.selectedFiles()){
            FileResource f = new FileResource(fr);
            double current = getColdestInDay(f.getCSVParser());
            if(current<temp){
                temp = current;
                filename = fr.getName();
            }
        }
        System.out.println("Lowest temp in all files: "+temp);
        System.out.println("FileName for Lowest Temp: "+filename);
    }
    
    public double getLowHumidInDay(CSVParser parser){
        double humid = 100.00;
        double temp = 0;
        String dateutc = "";
        for(CSVRecord record: parser){
            try{
               temp = Double.parseDouble(record.get("Humidity"));
            }catch(Exception e){
                System.out.println(e);
            }
            if((temp<humid) && (temp>0)){
                humid = temp;
                dateutc = record.get("DateUTC");
            }
        }
        System.out.println("Lowest humid in day: "+humid);
        System.out.println("Lowest humid in day hour: "+dateutc);
        return humid;
    }
    
    public void filesWithLowestHumid(){
        double humid = 100;
        String filename = "";
        String dtu = "";
        DirectoryResource dir = new DirectoryResource();
        for(File fr: dir.selectedFiles()){
            FileResource f = new FileResource(fr);
            double current = getLowHumidInDay(f.getCSVParser());
            if(current<humid){
                humid = current;
                filename = fr.getName();
            }
        }
        System.out.println("Lowest humid in all files: "+humid);
        System.out.println("FileName for lowest humidity: "+filename);
    }
    
    public void avgTempinFile(CSVParser parser){
        double temp = 0;
        int count = 0;
        for(CSVRecord record: parser){
            temp += Double.parseDouble(record.get("Humidity"));
            count+=1;
        }
        double avg = temp/count;
        System.out.println("Avg: "+avg);
    }
    
    public void test(){
        //FileResource fr = new FileResource();
        //CSVParser parser1 = fr.getCSVParser();
        //CSVParser parser2 = fr.getCSVParser();
        //getColdestInDay(parser1);
        //printColdestInDayTime(parser1, parser2);
        filesWithColdestTemp();
        //getLowHumidInDay(parser1);
        //filesWithLowestHumid();
        //avgTempinFile(parser1);
    }
}
