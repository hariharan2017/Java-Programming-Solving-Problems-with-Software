
public class Quiz {
    public static String findGene(String str){
        str = str.toUpperCase();
        int startInd = str.indexOf("ATG");
        int curr = findEndIndex(str, startInd);
        if(startInd>0){
            while(curr>0){
                int diff = (curr - startInd);
                if(diff%3 == 0){
                    return str.substring(startInd, curr+3);
                }
                else{
                    curr = findEndIndex(str, curr+1);
                }
        }  
    }
    return "";
    }
    
    public static int findEndIndex(String str,int pos){
        int endTAA = str.indexOf("TAA", pos);
        int endTAG = str.indexOf("TAG", pos);
        int endTGA = str.indexOf("TGA", pos);
        int currInd = -1; 
        if(endTAA>0 && endTAG>0 && endTGA>0){
            currInd = Math.min(endTAA, Math.min(endTAG, endTGA));
        }else if(endTAA>0){
            if(endTAG>0)
            currInd = Math.min(endTAA, endTAG);
            else if(endTGA>0)
            currInd = Math.min(endTAA, endTGA);
        }else if(endTAG>0){
            if(endTGA>0)
            currInd = Math.min(endTAG, endTGA);
        }else if(endTAA>0){
            currInd = endTAA;
        }else if(endTAG>0){
            currInd = endTAG;
        }else if(endTGA>0){
            currInd = endTGA;
        }             
        return currInd;
    }
    
    public static void main(String[] args){
     String dna1 = "AATATGGATAATAATGAATGAAA";
     System.out.println("DNA1: "+dna1);
     System.out.println("Hello: "+findGene(dna1));   
    }
}
