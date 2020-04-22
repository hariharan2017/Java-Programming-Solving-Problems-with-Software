import edu.duke.*;
import org.apache.commons.csv.*;

public class example2 {
    public void testParsing(CSVParser parser, String item){
        for(CSVRecord record: parser){
            String export = record.get("Exports");
            if(export.contains(item)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public void countryInfo(CSVParser parser, String countryin){
        for(CSVRecord record: parser){
            String country = record.get("Country");
            if(country.equals(countryin)){
                System.out.print(country+": ");
                System.out.print(record.get("Exports")+": ");
                System.out.print(record.get("Value (dollars)")+": ");
            }
        }
    }
    
    public void twoExport(CSVParser parser, String export1, String export2){
        for(CSVRecord record: parser){
            String export = record.get("Exports");
            if(export.contains(export1) && export.contains(export2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public void noExport(CSVParser parser, String exportItem){
        int count = 0;
        for(CSVRecord record: parser){
            String export = record.get("Exports");
            if(export.contains(exportItem)){
                count++;
            }
        }
        System.out.println("No: "+count);
    }
    
    public void getMoney(CSVParser parser, String moneyItem){
        int count = 0;
        for(CSVRecord record: parser){
            String money = record.get("Value (dollars)");
            if(money.length() > moneyItem.length()){
                count++;
                System.out.println(record.get("Country"));
            }
        }
        System.out.println("No: of countries: "+count);
    }
    
    public void test(){
     FileResource fr = new FileResource();
     CSVParser parser = fr.getCSVParser();
     //testParsing(parser, "coffee");
     //countryInfo(parser, "Nauru");
     //twoExport(parser, "cotton", "flowers");
     //noExport(parser, "cocoa");
     getMoney(parser, "$999,999,999,999");
    }
}
