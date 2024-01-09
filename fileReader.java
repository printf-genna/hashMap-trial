import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

     public class Fail2Ban {
     public static void main(String []args) throws FileNotFoundException{
        
        File inputfile = new File(args[0]);
        File outputfile= new File(args[1]);
        Scanner input = new Scanner(inputfile);
        PrintWriter output = new PrintWriter(outputfile);
        HashMap <String,Integer> Frequency = new HashMap<String,Integer>();

          while(input.hasNextLine()){
            String line = input.nextLine();
            String[] parts = line.split("\\s");
            if(line.contains("Invalid")){
              String ipAddress = parts[parts.length-1];
              Frequency.put(ipAddress, Frequency.getOrDefault(ipAddress,0)+1);
           }
           }

            for(String ipAddress : Frequency.keySet()){
              if (Frequency.get(ipAddress)>=3){
                  output.println(ipAddress);
          }
          }
            input.close();
            output.close();
       

        
        }
        }
