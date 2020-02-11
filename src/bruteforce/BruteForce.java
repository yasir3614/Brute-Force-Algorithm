package bruteforce;

import java.io.*; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

class  BruteForce 
{
    
    
    
      
  public static int getRandomNumber(){
    
    int data;
    Random rnd = new Random();
    data = rnd.nextInt(9000000) + 1000000;
    return data;
    }
         
    static void lcs(String s1, String s2, int m, int n) throws FileNotFoundException 
    { 
    
        //CHEKC OUTPUT IN FILE .
        String filename = ("Output_SizeOfS1_"+m+"_SizeOfS2_"+n);
        try (PrintWriter out = new PrintWriter("E:\\uni stuff\\Semester Work\\5th Semester\\Algo\\BruteForce\\"+filename+".txt")) {
            
        int[][] L = new int[m+1][n+1]; 
        
        long startTime = System.nanoTime();
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[i][j] = 0; 
                else if (s1.charAt(i-1) == s2.charAt(j-1)) 
                    L[i][j] = L[i-1][j-1] + 1; 
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
            } 
        } 
   
        int index = L[m][n]; 
        int temp = index; 
   
        char[] lcs = new char[index+1]; 
        lcs[index] = ' ';  
        int i = m, j = n; 
        while (i > 0 && j > 0) 
        { 
            if (s1.charAt(i-1) == s2.charAt(j-1)) 
            { 
                lcs[index-1] = s1.charAt(i-1);  
                i--;  
                j--;  
                index--;      
            } 
   
            else if (L[i-1][j] > L[i][j-1]) 
                i--; 
            else
                j--; 
        } 
   long endTime   = System.nanoTime();
   long totalTime = endTime - startTime;
        out.println("LCS of "+s1+" and "+s2+" is ");
            System.out.println("LCS of "+s1+" and "+s2+" is ");
              for(int k=0;k<=temp;k++) {
                  System.out.print(lcs[k]); 
                    out.print(lcs[k]); 
                    
              }
        out.println("\n");
        out.print("\nAverage Execution Time: "  + totalTime + " ns");
        System.out.println("\nAverage Execution Time: "  + totalTime + " ns"); 

        }     
    }   

    public static String stringGenerator(int n){
         String s = "";
        int number = getRandomNumber();
        
        for(int i=0;i<20;i++){
        s += String.valueOf(number);
        number=getRandomNumber();
        }
        
        if(n==10){
        s = s.substring(0, s.length()-130);
        }
        if(n==50){
        s = s.substring(0, s.length()-90);
        }
        if(n==80){
         s = s.substring(0, s.length()-60);
        }
        if(n==100){
         s = s.substring(0, s.length()-40);
        }
        return s;
    }
      
    public static void main (String[] args) throws FileNotFoundException  
    { 
        
         String s1= "";
         String s2= "";
         int m = s1.length(); 
         int n = s2.length(); 
       // lcs(s1, s2, m, n); 
//        
//        s1 = stringGenerator(10);
//         s2 = stringGenerator(10);
//         m = s1.length(); 
//         n = s2.length(); 
//        lcs(s1, s2, m, n);
//        
//        s1 = stringGenerator(50);
//         s2 = stringGenerator(50);
//         m = s1.length(); 
//         n = s2.length(); 
//        lcs(s1, s2, m, n);
//        
//        s1 = stringGenerator(80);
//         s2 = stringGenerator(80);
//         m = s1.length(); 
//         n = s2.length(); 
//        lcs(s1, s2, m, n);
        
        s1 = stringGenerator(100);
         s2 = stringGenerator(100);
         m = s1.length(); 
         n = s2.length(); 
        lcs(s1, s2, m, n);
    } 
} 