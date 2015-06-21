package test;

import binary.BinarySubstractor;

public class Test {
  
  public static void main(String[] args) {
    int numberOne = -25;
    int numberTwo = 25;
    BinarySubstractor bs = new BinarySubstractor(numberOne, numberTwo);
    
    String binaryResult = bs.performSubstraction();
    int decimalResult = Integer.parseInt(binaryResult, 2);
    
    System.out.printf("%s - %s = %s\n", 
      bs.getBinaryOne(), bs.getBinaryTwo(), binaryResult);
    
    System.out.printf("%d - %d = %d\n", numberOne, numberTwo, decimalResult);
      
  }

}