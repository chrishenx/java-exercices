/**
  
  Clase para restar números positivos y devolver el resultado en binario.
  
  @author Christian González 
  @authorAlias (CPlayMasH - chrishenx)
  @date June 6th, 2015
 */

package binary;

import java.lang.IllegalArgumentException;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class BinarySubstractor {
  private int numberOne;
  private int numberTwo;
  
  public BinarySubstractor(int numberOne, int numberTwo) {
    if (numberOne < 0 || numberTwo < 0) {
      throw new IllegalArgumentException("No se permiten numeros negativos");
    }
    this.numberOne = max(numberOne, numberTwo);
    this.numberTwo = min(numberOne, numberTwo);
  }
  
  /// Devuelve el binario correspondiente al valor absoluto de la resta
  public String performSubstraction() {
    String[] binaries = getBinaries();
    if (binaries != null) {
      String binaryOne = binaries[0];
      String binaryTwo = binaries[1];
      while (binaryOne.length() > binaryTwo.length()) {
        binaryTwo = "0" + binaryTwo;
      }
      String result = "";
      int carry = 0;
      final int bits = binaryOne.length();
      for (int i = bits - 1; i >= 0; i--) {
        int bitOne = Character.getNumericValue(binaryOne.charAt(i));
        int bitTwo = Character.getNumericValue(binaryTwo.charAt(i));
        int temporalResult = abs(bitOne - carry);
        carry = bitOne - carry == -1 ? 1 : 0;
        result = abs(temporalResult - bitTwo) + result;
        if (temporalResult - bitTwo == -1) {
          carry = 1;
        }
      }
      return result;
    }
    return "0"; 
  }
  
  public String getBinaryOne() {
    return Integer.toBinaryString(numberOne);
  }
  
  public String getBinaryTwo() {
    return Integer.toBinaryString(numberTwo);
  }
  
  private String[] getBinaries() {
    if (numberOne > numberTwo) {
      return new String[] { getBinaryOne(), getBinaryTwo() };
    } else if (numberOne < numberTwo) {
      return new String[] { getBinaryTwo(), getBinaryOne()  };
    }
    return null;
  }

}