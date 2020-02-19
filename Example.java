package example;


public class Example {
    public static void main(String[]args){
        System.out.println("Number\tSquare\tCube");
         
        for(int i=0;i<11;i++){           
            double square=Math.pow(i, 2);
            double cube=Math.pow(i,3);
            
            //System.out.println(i+"\t"+square+"\t"+cube);
            System.out.printf("%d\t%.0f\t%.0f\n", i,square,cube);
        
     
        }
    }    
    
}
