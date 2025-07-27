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
            int pivo= array[0];
            boolean[] highestElements=new boolean[array.length];
            int sizeTopArray=0;
            boolean[] lowestElements=new boolean[array.length];
            int sizeBottomArray=0;
            for(int i=0;i<array.length; i++){
                if(array[i]>pivo){
                    highestElements[i]=true;
                    lowestElements[i]=false;
                    sizeTopArray++;
                }
                if(array[i]<pivo){
                    lowestElements[i]=true;
                    highestElements[i]=false;
                    sizeBottomArray++;
                }
            }

            int[] topArray=new int[sizeTopArray];
            int topArrayIterator=0;
            int[] bottomArray=new int[sizeBottomArray];
            int bottomArrayIterator=0;

            for(int i=0;i<array.length;i++){
                if(highestElements[i]==true){
                    topArray[topArrayIterator]=array[i];
                    topArrayIterator++;
                }
                if(lowestElements[i]==true){
                    bottomArray[bottomArrayIterator]=array[i];
                    bottomArrayIterator++;
                }
            }

            int[] sortBottom= quickSort(bottomArray);
            int[] sortTop=quickSort(topArray);

            int[] result= new int[bottomArray.length+1+topArray.length];
            int resultIterator=0;

            for(int i=0;i<bottomArray.length;i++){
                result[resultIterator]=sortBottom[i];
                resultIterator++;
            }
            result[resultIterator]=pivo;
            resultIterator++;
            for(int i=0; i<topArray.length; i++){
                result[resultIterator]=sortTop[i];
                resultIterator++;
            }
            System.out.println("result: "+printArray(result));
            return result;
        }

    }
}