
public class Second {
    public static String findGene(String str, String startCodon, String endCodon){
     String res = "";   
     str = str.toUpperCase();
     System.out.println(str);
     int startInd = str.indexOf(startCodon);
     int endInd = str.indexOf(endCodon,startInd+3);
     if(startInd>0 & endInd>0){
         res = str.substring(startInd, endInd+3);
         System.out.println(res.length());
         if(res.length()%3==0){
             return res;
         }
     }
     res = "";
     return res;
    }
    
    public static void main(String[] args){
        String dna1 = "ATTTATAGAT";
        String dna2 = "ATTATGAGGA";
        String dna3 = "AATGgattgaTAA";
        String dna4 = "AAGATGAGAGTATAA";
        String dna5 = "AAGATGAAGTATAA";
        System.out.println("DNA1: "+findGene(dna1,"ATG","TAA"));
        System.out.println("");
        System.out.println("DNA2: "+findGene(dna2,"ATG","TAA"));
        System.out.println("");
        System.out.println("DNA3: "+findGene(dna3,"ATG","TAA"));
        System.out.println("");
        System.out.println("DNA4: "+findGene(dna4,"ATG","TAA"));
        System.out.println("");
        System.out.println("DNA5: "+findGene(dna5,"ATG","TAA"));
        System.out.println("");
    }
}
