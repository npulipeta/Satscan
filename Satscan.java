import java.io.*;
import java.util.*;
import java.math.*;

class Coordinates {
    final double latitude;
    final double longitude;

    Coordinates(double lat, double lon) {
        latitude = lat;
        longitude = lon;
    }
}

public class Satscan {
	
	//Distance function calculates the straight distance, same as we draw straight line between two points 
	//This is totally different from google map distance, since it uses road dataset for calculating distance.
	public static double distance(double lat1, double lon1, double lat2, double lon2) {
		  double p = 0.017453292519943295;    // Math.PI / 180
		  //char c = Math.cos;
		  double a = 0.5 - Math.cos((lat2 - lat1) * p)/2 + 
				  Math.cos(lat1 * p) * Math.cos(lat2 * p) * 
		          (1 - Math.cos((lon2 - lon1) * p))/2;

		  return 12742 * Math.asin(Math.sqrt(a)); //In KM
		}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("test.csv"));
        String line = br.readLine();
        String splitBy = ",";
        List<Coordinates> Address = new ArrayList<>();
        
        while((line = br.readLine()) != null){
            String[] b = line.split(splitBy);
            System.out.println(b[0]+": "+b[1]+" "+b[2]);
            double lat2 = Double.parseDouble(b[1]);
            double long2 = Double.parseDouble(b[2]);
            
            Address.add(new Coordinates(lat2, long2));
            //System.out.println(distance(-111.9606778, 33.38364645, lat2, long2));
       }
       br.close();
        
       System.out.println("Nirmal to Bhainsa(testing):"+distance(19.096412, 78.342975, 19.103066, 77.965299));
       //Actual distance is 41.5 km, but it is showing 39.69 km, because there are two curves.
       //System.out.println(Address.get(499).latitude);
       
       double[][] radius_grid = new double[Address.size()][Address.size()];
       
       for(int i=0;i<Address.size();i++){
    	   
    	   for(int j=0;j<i;j++){
    		  radius_grid[i][j] = distance(Address.get(i).latitude, Address.get(i).longitude, Address.get(j).latitude, Address.get(j).longitude);
    		  radius_grid[j][i] = radius_grid[i][j];
    	   }
    	   
    	   radius_grid[i][i] = 0.0;
       }
       
       for(int i=0;i<Address.size();i++){
    	   
    	   for(int j=0;j<Address.size();j++){
    		   if(i!=j){
    			   
    			   for(int k=0;k<Address.size();k++){
    				   
    			   }
    		   }
    	   }
       }
       
	}
}
