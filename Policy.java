public class Policy // Public class named Policy
{
   //Declaring fields for Policy class
   private int polNum ;
   private String provName, fName, lName;
   private double height, weight, age, smokeStatusChoice;  

   /**
   * Constructor that accepts no arguments ( no-arg constructor)
   * @param polNum used to hold value of policy number
   * @param age used to hold age value
   * @param provName used to hold provider name 
   * @param fName used to hold the first name of policy holder
   * @param lName used to hold the last name of policy holder
   * @param smokeStatusChoice used to hold the smoker status
   * @param height used to hold the height value
   * @param weight used to hold the weight value
   */
   public Policy()
   {    
      polNum = 0;
      age = 0;
      provName = ""; 
      fName = ""; 
      lName = ""; 
      smokeStatusChoice = 1.0;
      height = 0.0; 
      weight = 0.0;  
   }
   
   /**
   * Constructor that accepts arguments
   *
   * @param h used to hold value of the height
   * @param w used to hold the value of the weight
   * @param a used to hold the value of the age
   */
   public Policy(double h, double w, double a)
   {
      height = h;
      weight = w;
      age = a;
   }
   
   //setters methods for fields in the Policy class
   public void setPolicyNum(int pn)
   {
      polNum = pn;
   }
   public void setProviderName(String prn)
   {
      provName = prn;
   }
   public void setFirstName(String fn)
   {
      fName = fn;
   }
   public void setLastName(String ln)
   {
      lName = ln;
   }
   public void setHeight(double ht)
   {
      height = ht;
   }
   public void setWeight(double wt)
   {
      weight = wt;
   }
   public void setAge(double ag)
   {
      age = ag;
   }

   public void setSmokeStatusChoice(double ssc)
   {
      smokeStatusChoice = ssc;
   }
   
   // getter methods for fields in the Policy class
   /**
   * @return policy Number value
   */
   public int getPolicyNum()
   {
      return polNum;
   }
   /**
   * @return provider name value
   */
   public String getProviderName()
   {
      return provName;
   }
   /**
   * @return first name
   */
   public String getFirstName()
   {
      return fName;
   }
   /**
   * @return last name
   */
   public String getLastName()
   {
      return lName;
   }
   /**
   * @return smoker status
   */
   public double getSmokeStatusChoice()
   {
      return smokeStatusChoice;
   }
   /**
   * @return height value
   */
   public double getHeight()
   {
      return height;
   }
   /**
   * @return weight value
   */
   public double getWeight()
   {
      return weight;
   }
   /**
   * @return age value
   */
   public double getAge()
   {
      return age;
   }

   /**
   * Method to calculate the BMI
   *
   * @return bmi calculation
   */
   public double calculateBMI()
   {
      return (weight * 703)/(height * height);
   }
   
   /**
   * Method to calculate the price for policy holders insurance
   *
   * @return insurance policy calculation
   */
   public double calculateInsurancePolicy(double ssc, double bmi, double a)
   {
      double price = 600;
      double smokerStatusChoice = ssc;
      double bodyMassIndex = bmi;
      age = a;
      
      if(age > 50 ){
         price = price + 75;
      } else if (smokerStatusChoice == 2){
         price = price + 100;
      } else if (bodyMassIndex >= 35){
         price = price + ((bodyMassIndex - 35)*20);
      } 
      return price;
      
   }
   
}