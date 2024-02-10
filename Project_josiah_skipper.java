import java.util.Scanner; //import Scanner class to read user input

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
      
      //Askiing user the promt questions and storing the responses in the corresponding variables.
      System.out.print("Please enter the Policy Number: ");
      policyNumber = keyboard.nextInt();
      keyboard.nextLine();
      System.out.print("Please enter the Provider Name: ");
      providerName = keyboard.nextLine(); 
      System.out.print("Please enter the Policyholder’s First Name: ");
      firstName = keyboard.nextLine();
      System.out.print("Please enter the Policyholder’s Last Name: ");
      lastName = keyboard.nextLine(); 
      System.out.print("Please enter the Policyholder’s Age: ");
      policyHolderAge = keyboard.nextDouble();
      keyboard.nextLine();
      System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
      smokeStatus = keyboard.nextLine(); 
      System.out.print("Please enter the Policyholder’s Height (in inches): ");
      policyHolderHeight = keyboard.nextDouble();
      System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
      policyHolderWeight = keyboard.nextDouble();
      
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