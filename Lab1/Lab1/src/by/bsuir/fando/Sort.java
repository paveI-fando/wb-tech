package by.bsuir.fando;


/**
 * This class provides functional to sort Array
 * @author Fando
 *
 */
public class Sort {
	
	public static  int compare(String str1, String str2) {
        int res = str1.compareTo(str2);
        return res;
    }
	
	public static void bubbleSort(String[][] arr, int index, boolean sortFlag){   
		if (sortFlag == true)
	    for(int i = arr.length-1 ; i > 1 ; i--){
	        for(int j = 1 ; j < i ; j++){
	            if( compare(arr[j][index], arr[j+1][index]) > 0 ){
	            	for(int t = 0; t < 4; t++) {
	            		String tmp = arr[j][t];
	            		arr[j][t] = arr[j+1][t];
	            		arr[j+1][t] = tmp;
	            	}
	            }
	        }
	    }
		if (sortFlag == false)
		    for(int i = arr.length-1 ; i > 1 ; i--){
		        for(int j = 1 ; j < i ; j++){
		            if( compare(arr[j][index], arr[j+1][index]) < 0 ){
		            	for(int t = 0; t < 4; t++) {
		            		String tmp = arr[j][t];
		            		arr[j][t] = arr[j+1][t];
		            		arr[j+1][t] = tmp;
		            	}
		            }
		        }
		    }
	}
}
