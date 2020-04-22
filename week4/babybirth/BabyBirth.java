import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class BabyBirth {
    public void printName(){
    FileResource fr = new FileResource();
    int totalBirth = 0;
    int boyBirth = 0;
    int girlBirth = 0;
    int noBoyNames = 0;
    int noGirlNames = 0;
    for(CSVRecord rec: fr.getCSVParser(false)){
        int numBorn = Integer.parseInt(rec.get(2));
        totalBirth += numBorn;
        if((rec.get(1)).equals("M")){
            boyBirth += numBorn;
            noBoyNames += 1;
        }else{
            girlBirth += numBorn;
            noGirlNames += 1;
        }
    }
    System.out.println("Total Birth: "+totalBirth);
    System.out.println("Total Boys: "+boyBirth+" Number of boys names: "+noBoyNames);
    System.out.println("Total Girls: "+girlBirth+" Number of girls names: "+noGirlNames);
   }
   
   public int getRank(int year, String name, String gen){
    FileResource fr = new FileResource("yob"+year+".csv");
    int count = 0;
    for(CSVRecord rec: fr.getCSVParser(false)){
        if(gen.equals(rec.get(1))){
            count += 1;
            if(name.equals(rec.get(0))){
             break;   
            }
        }
    }
    System.out.println("Rank is: "+count);
    return count;
   }
   
   public void getName(int year, int rank, String gen){
    FileResource fr = new FileResource("yob"+year+".csv");
    int count = 0;
    for(CSVRecord rec: fr.getCSVParser(false)){
        if(gen.equals(rec.get(1))){
            count += 1;
            if(count == rank){
                System.out.println(rec.get(0));
                break;   
            }
        }
    }
   }
   
   public void whatIsNameInYear(String name, int year, int newyear, String gen){
       FileResource fr = new FileResource("yob"+newyear+".csv");
       int rank = getRank(year, name, gen);
       int count = 0;
       for(CSVRecord rec: fr.getCSVParser(false)){
           if(gen.equals(rec.get(1))){
             count += 1;
             if(count == rank){
                System.out.println(rec.get(0));
                }
            }
        }
   }
   
   public void yearofhighestrank(String name, String gen){
       DirectoryResource dr = new DirectoryResource();
       int count = 0;
       int min = 1000000;
       String year = "";
       boolean flag = false;
       for(File f: dr.selectedFiles()){
           FileResource fr = new FileResource(f);
           for(CSVRecord rec: fr.getCSVParser(false)){
               if(gen.equals(rec.get(1))){
                   count += 1;
                   if(name.equals(rec.get(0))){
                    flag = true;
                    break;
                    }
                }
           }
           if((count<min) && (flag == true)){
             min = count; 
             year = f.toString();
            }
       }
       System.out.println("Year: "+year+" Rank: "+min);
   }
   
   public void getAverageRank(String name, String gen){
       DirectoryResource dr = new DirectoryResource();
       int totalRank = 0;
       double avgRank = 0;
       int fileCount = 0;
       for(File f: dr.selectedFiles()){
           int count = 0;
           fileCount += 1;
           FileResource fr = new FileResource(f);
           for(CSVRecord rec: fr.getCSVParser(false)){
               if(gen.equals(rec.get(1))){
                   count += 1;
                   if(name.equals(rec.get(0))){
                     totalRank += count;
                     break;
                    }
                }
            }
        }
        System.out.println("Total Rank: "+totalRank+" "+"fileCount: "+fileCount);
        avgRank = ((double)totalRank)/fileCount;
        System.out.println("Avg rank: "+avgRank);
    }
   
   public int getTotalBirthsRankedHigher(int year, String name, String gen){
       FileResource fr = new FileResource("yob"+year+".csv");
       int total = 0;
       for(CSVRecord rec: fr.getCSVParser(false)){
           if(gen.equals(rec.get(1))){
               if(!name.equals(rec.get(0))){
                   total += Integer.parseInt(rec.get(2));
                }else{
                    break;
                }
            }
        }
        System.out.println("Total higher: "+total);
        return total;
   }
    
   public void test(){
     //getRank(1960,"Emily","F");  
     //getRank(1971,"Frank","M");  
     //getName(1980, 350, "F"); 
     //getName(1982, 450, "M");
     //whatIsNameInYear("Susan", 1972, 2014, "F");
     //whatIsNameInYear("Owen", 1974, 2014, "M");
     //yearofhighestrank("Isabella","F");
     yearofhighestrank("Genevieve","F");
     yearofhighestrank("Mich","M");
     getAverageRank("Susan","F");
     getAverageRank("Robert","M");
     getTotalBirthsRankedHigher(1990, "Emily", "F");
     getTotalBirthsRankedHigher(1990, "Drew", "M");
    }
}
