package largesttripleproduct;


// Add any extra import statements you may need here
import java.util.Arrays;

class Main {

  // Add any helper functions you may need here
  
  int [] sortList(int[] arr, int index)
  {
      int [] ret = new int[index+1]; 
     if( index < 2 )
     {
        for(int i = 0; i <= index ; i++){
          ret[i] = -1;
        }
       return ret;
     }
    
     for(int i = 0; i <= index ; i++){
          ret[i] = arr[i];
     }
    
    Arrays.sort(ret);
    return ret;
     
    
  }
  
  int retProduct( int [] arr , int index )
  {
     if ( index < 2 )
       return -1;
  
      int [] ret = sortList(arr, index);
      return ret[index]*ret[index-1]*ret[index-2];
   
  }
  

  int[] findMaxProduct(int[] arr) {
    // Write your code here
    int [] ret = new int[arr.length];
    for( int i = 0; i < arr.length;i++)
    {
       ret[i] = retProduct(arr, i);
    }
    
    return ret;
      
    
  }





  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  
  void check(int[] expected, int[] output) {
    int expected_size = expected.length; 
    int output_size = output.length; 
    boolean result = true; 
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);  
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected); 
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  
  void printIntegerArray(int[] arr) {
    int len = arr.length; 
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  
  public void run() {
    int[] arr_1 = {1, 2, 3, 4, 5};
    int[] expected_1 = {-1, -1, 6, 24, 60};
    int[] output_1 = findMaxProduct(arr_1);
    check(expected_1, output_1);
    
    int[] arr_2 = {2, 4, 7, 1, 5, 3};
    int[] expected_2 = {-1, -1, 56, 56, 140, 140};
    int[] output_2 = findMaxProduct(arr_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
