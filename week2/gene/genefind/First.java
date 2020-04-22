
public class First {
    public static String findGene(String s){
     String res = "";
     int startInd = s.indexOf("ATG");
     int endInd = s.indexOf("TAA",startInd+3);
     if(startInd>0 & endInd>0){
         res = s.substring(startInd, endInd+3);
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
        String dna3 = "AAGGTTGGGAA";
        String dna4 = "AAGATGAGAGTATAA";
        String dna5 = "AAGATGAAGTATAA";
        System.out.println("DNA1: "+findGene(dna1));
        System.out.println("DNA2: "+findGene(dna2));
        System.out.println("DNA3: "+findGene(dna3));
        System.out.println("DNA4: "+findGene(dna4));
        System.out.println("DNA5: "+findGene(dna5));
    }
}
