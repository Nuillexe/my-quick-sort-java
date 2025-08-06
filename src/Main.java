import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int[] array={9,3,5,10,6,7,1,8,2};
        System.out.println("Array original: "+ printArray(array));
        array=quickSort(array);
        System.out.println("Sorted array:"+ printArray(array));

    }

    static String printArray(int[] array){
        String arrayInString="";
        for(int i=0; i<array.length;i++){
            arrayInString+=array[i]+", ";
        }
        return arrayInString;

    }

    static int[] quickSort(int[] array){
        if(array.length<2){
            System.out.println(printArray(array));
            return array;
        }else{
            int pivoIndex=(int)(Math.random()*(array.length-1));
            int pivo= array[pivoIndex];
            boolean[] isHighestElement=new boolean[array.length];
            int sizeTopArray=0;
            int sizeBottomArray=0;

            for(int i=0;i<array.length; i++){
                if(array[i]>pivo){
                    isHighestElement[i]=true;
                    sizeTopArray++;
                }else if(i!= pivoIndex){
                    sizeBottomArray++;
                }
            }

            int[] topArray=new int[sizeTopArray];
            int topArrayIterator=0;
            int[] bottomArray=new int[sizeBottomArray];
            int bottomArrayIterator=0;

            for(int i=0;i<array.length;i++){
                if(isHighestElement[i]==true){
                    topArray[topArrayIterator]=array[i];
                    topArrayIterator++;
                }else if(i!= pivoIndex){
                    bottomArray[bottomArrayIterator]=array[i];
                    bottomArrayIterator++;
                }
            }

            bottomArray= quickSort(bottomArray);
            topArray=quickSort(topArray);

            int[] result= new int[bottomArray.length+1+topArray.length];
            int resultIterator=0;

            for(int i=0;i<bottomArray.length;i++){
                result[resultIterator] = bottomArray[i];
                resultIterator++;
            }
            result[resultIterator]=pivo;
            resultIterator++;
            for(int i=0; i<topArray.length; i++){
                result[resultIterator] = topArray[i];
                resultIterator++;
            }
            System.out.println("result: "+printArray(result));
            return result;
        }
    }
}