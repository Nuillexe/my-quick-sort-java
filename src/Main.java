import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array={9,3,5,10,6,7,1,8,2};
        System.out.println("Array original: "+Arrays.toString(array));
        array=quickSort(array);
        System.out.println("Sorted array:"+ Arrays.toString(array));

    }

    static String printArray(int[] array){
        String[] strArray = new String[array.length];
        for(int i=0; i<array.length;i++){
            strArray[i]= String.valueOf(array[i]);
        }
        return String.join(",",strArray);
    }

    static int[] quickSort(int[] array){
        if(array.length<2){
            System.out.println(printArray(array));
            return array;
        }else{
            int pivoIndex=(int)(Math.random()*(array.length-1));
            int pivo= array[pivoIndex];

            int[] bottomArray= quickSort( partition(array,pivo,pivoIndex)[0]);
            int[] topArray= quickSort( partition(array,pivo,pivoIndex)[1]);

            return joinArrays(bottomArray,pivo,topArray);
        }
    }

    static int[][] partition(int[] array, int pivo,int pivoIndex){
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
            if(isHighestElement[i]){
                topArray[topArrayIterator]=array[i];
                topArrayIterator++;
            }else if(i!= pivoIndex){
                bottomArray[bottomArrayIterator]=array[i];
                bottomArrayIterator++;
            }
        }

        return new int[][] {bottomArray,topArray};
    }

    static int[] joinArrays( int[] bottomArray, int pivo, int[] topArray){
        int[] result= new int[bottomArray.length+1+ topArray.length];
        int resultIterator=0;

        for(int bottomNumber: bottomArray){
            result[resultIterator] = bottomNumber;
            resultIterator++;
        }
        result[resultIterator]=pivo;
        resultIterator++;
        for(int topNumber: topArray){
            result[resultIterator] = topNumber;
            resultIterator++;
        }
        System.out.println("result: "+printArray(result)); // I used this printing for me watch the algorithm function in the minimun details
        return result;
    }
}