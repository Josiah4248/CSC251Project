import java.util.Scanner; //import Scanner class to read user input
import java.io.*;
//import java.util.ArrayList;

public class Project_josiah_skipper
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);//creating instance of scanner class named keyboard
      
      //declaring local variables
      int policyNumber;
      String providerName, firstName, lastName, smokeStatus;
      double policyHolderHeight, policyHolderWeight, policyHolderAge, bodyMass, smokeStatusChoice,
         policyPrice;
      

      // want to open a process text file containing info about Charlotte weather
      File file = new File("PolicyInformation.txt");
      
      if(!file.exists())
      {
         System.out.println("Unable to open file.");
         System.exit(0);
      }
      
      Scanner inputFile = new Scanner(file);//"open the file"

        
      while(inputFile.hasNext())
      {
        policyNumber = inputFile.nextInt(); 
        providerName = inputFile.nextLine();
        firstName = inputFile.nextLine();
        lastName = inputFile.nextLine();
        policyHolderAge = inputFile.nextDouble();
        smokeStatus = inputFile.nextLine();
        policyHolderHeight = inputFile.nextDouble();
        policyHolderWeight = inputFile.nextDouble();
        
        if(inputFile.hasNext())
        inputFile.nextLine();//clear the newline
        if(inputFile.hasNext())
        inputFile.nextLine();// skip blank line in file
      }
      inputFile.close();//"close the file"

      
      /* if-else statement to store a numeric value in the
      smokeStatusChoice variable based on the String response from the user. This
      will help to calculate the insurance policy price
      */ 
      if (smokeStatus == "smoker"){
         smokeStatusChoice = 2;
      }else {
         smokeStatusChoice = 1;
      }
      
      //Creating a new Policy object named project that accepts arguments to initiate the object
      Policy project = new Policy(policyHolderHeight, policyHolderWeight, policyHolderAge);
      
      //setting project instance of the Policy class items to the values given by user
      project.setPolicyNum(policyNumber);
      project.setProviderName(providerName);
      project.setFirstName(firstName);
      project.setLastName(lastName);
      project.setHeight(policyHolderHeight);
      project.setWeight(policyHolderWeight);
      project.setAge(policyHolderAge);

      //calling the calculateBMI method from the Policy class and storing the value in the bodyMass variable
      bodyMass = project.calculateBMI();
      /*calling the calculateInsurancePolicy method from the Policy class 
      and storing the value in policyPrice variable*/ 
      policyPrice = project.calculateInsurancePolicy(smokeStatusChoice, bodyMass,policyHolderAge );
    
      //Printing out recorded data with formatting to match the requirement given.
      System.out.println("Policy Number: " + project.getPolicyNum());
      System.out.println("");
      System.out.println("Provider Name: " + project.getProviderName());
      System.out.println(" ");
      System.out.println("Policyholder’s First Name: " + project.getFirstName());
      System.out.println("");
      System.out.println("Policyholder’s Last Name: " + project.getLastName());
      System.out.println("");
      System.out.println("Policyholder’s Age: " + project.getAge());
      System.out.println("");
      System.out.println("Policyholder’s Smoking Status: " + smokeStatus);
      System.out.println("");
      System.out.printf("Policyholder’s Height: $%.1f inches\n" , project.getHeight());
      System.out.println(" ");
      System.out.printf("Policyholder’s Weight: %.1f pounds\n" , project.getWeight());
      System.out.println("");
      System.out.printf("Policyholder’s BMI: %.2f \n" , bodyMass);
      System.out.println("");
      System.out.printf("Policy Price: $%.2f \n" , policyPrice);  
   }
}