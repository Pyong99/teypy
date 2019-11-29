package stia1113;
import java.util.Scanner;

public class NextDayDelivery {
	
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);	
		int chose;
		
		do {
			System.out.println("Do you want Next-Day Delivery?"+"\n"+"1 Yes"+"\n"+"2 No");
			chose = input.nextInt();
			validpackagetype(chose);
			}while(!validchose(chose));
		input.close();	
	}

	public static boolean validchose(int select) {
		if(select==1||select==2) {			
			return true;
		}else{
			System.out.println("Please enter valid choice 1 or 2.");
			return false;
		}
	}
	
	public static void validpackagetype(int a) {
		Scanner input = new Scanner(System.in);
		int packagetype;
		if(a==1) {
			do {
				System.out.println("Enter your package type:"+"\n"+"1 Document(below 2kg)"+"\n"+"2 Parcel(above 2kg)");
				packagetype = input.nextInt();
				packagetypeselect(packagetype);			
			}while(!validchose(packagetype));			
		}else {	
		}
//	input.close();
	}
	
	public static void packagetypeselect (int a) {
		Scanner input = new Scanner(System.in);
		int dzone,pzone;
		if(a==1) {
			do {
				System.out.println("Enter your zone:"+"\n"+"1 Zone 1"+"\n"+"2 Zone 2"+"\n"+"3 Zone 3"+"\n"+"4 Zone 4"+"\n"+"5 Zone 5");
				dzone = input.nextInt();
				dzoneselect(dzone);				
			}while(!validzone(dzone));
		}
		
		if(a==2) {
			do {	
				System.out.println("Enter your zone:"+"\n"+"1 Zone 1"+"\n"+"2 Zone 2"+"\n"+"3 Zone 3"+"\n"+"4 Zone 4"+"\n"+"5 Zone 5");
				pzone = input.nextInt();
				pzoneselect(pzone);				
			}while(!validzone(pzone));
		}
//	input.close();	
	}
	
	public static boolean validzone(int select) {
		if(select>=1&&select<=5) {			
			return true;
		}else {
			System.out.println("Please enter valid zone within 1-5.");
			return false;		
		}
	}
	
	public static int dzoneselect(int dz) {
		switch(dz) {
		case 1:
			dmethod(4.9,0.8);									
			break;							
		case 2:
			dmethod(5.4,1);
			break;
		case 3:
			dmethod(6.9,1.5);
			break;
		case 4:
			dmethod(7.4,1.5);
			break;
		case 5:	
			dmethod(7.9,2);
			break;	
		}
		return dz;
	}
	
	public static int pzoneselect(int pz) {
		switch(pz) {
		case 1:
			pmethod(10.5,0.5);
			break;
		case 2:
			pmethod(16,2);
			break;
		case 3:
			pmethod(21,3);
			break;
		case 4:
			pmethod(26,3.5);
			break;
		case 5:	
			pmethod(31,4);
			break;		
		}
		return pz;
	}
	
	public static boolean validdweight(double weight) {
		if(weight>=500 && weight<=2000) {
			return true;
		}else{
			System.out.println("Please enter valid document's weight within 500g-2000g.");
			return false;
		}
	}
	
	public static boolean validpweight(double weight) {
		if(weight>=2.001) {
			return true;
		}else{
			System.out.println("Please enter valid parcel's weight above 2.001kg.");
			return false;
		}
	}
	
 	public static double dmethod(double fdPrice,double sdPrice) {
 		Scanner input = new Scanner(System.in);
 		double dWeight,totalsdPrice,dPrice=0;
 		int i=0;

 		do{
 			System.out.println("Enter the document's weight in g");
 			dWeight = input.nextDouble();
 					
 		}while(!validdweight(dWeight));
		
		if(dWeight<=500) {
			dPrice=fdPrice;
			
		}else {	
			
			if(((dWeight/1000)-0.5)%0.25!=0) {
				i=(int)((dWeight/1000-0.5)/0.25);
				totalsdPrice=(i+1)*sdPrice;
				
			}else {
				i=(int)((dWeight/1000-0.5)/0.25);
				totalsdPrice=i*sdPrice;
			}
		
			dPrice=fdPrice+totalsdPrice;
		}
	
		String documentprice = String.format("%.2f",dPrice);
		
		System.out.println("Your Next-Day Delivery is RM"+documentprice);
		
		input.close();
		return dPrice;
	}
	
	public static double pmethod(double fpPrice,double spPrice) {
		Scanner input = new Scanner(System.in);
		double pWeight,totalspPrice,pPrice=0;
		int j;

		do{
			System.out.println("Enter the parcel's weight in kg");
			pWeight = input.nextDouble();
			
		}while(!validpweight(pWeight));
		
		if(pWeight>=2.001 && pWeight<=2.5) {
			pPrice=fpPrice;
		}else {
			
			if((pWeight-2.5)%0.5!=0) {
				j=(int)((pWeight-2.5)/0.5);
				totalspPrice=(j+1)*spPrice;
				
			}else {
				j=(int)((pWeight-2.5)/0.5);
				totalspPrice=j*spPrice;
			}
			
			pPrice=fpPrice+totalspPrice;			
		}
		
		String parcelPrice = String.format("%.2f",pPrice);	
		System.out.println("Your Next-Day Delivery is RM"+parcelPrice);
		
		input.close();
		return pPrice;
	}

}
	
	
	
	
	
	
	

	








