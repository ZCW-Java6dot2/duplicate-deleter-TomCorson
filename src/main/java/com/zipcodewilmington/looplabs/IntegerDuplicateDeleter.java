package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer [] intarr){
        super(intarr);

    }
    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {

       Integer [] multiples = countMultiples(array);
       int finalArrayLength = calculateNewLength(multiples, maxNumberOfDuplications);
       Integer [] result = new Integer[finalArrayLength];
       int resultCount = 0;
       int multiplesCount = 0;
       int start = 0;
       int end = multiples[multiplesCount];
       while(multiplesCount < multiples.length) {
           for (int i = start; i < end; i++) {

                   if (multiples[multiplesCount] < maxNumberOfDuplications) {
                       result[resultCount] = array[i];
                       resultCount++;
                   }

           }
           start = start + multiples[multiplesCount];
           multiplesCount++;
           if(end != array.length){
               end = end + multiples[multiplesCount];
           }

       }
        return result;
    }
    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer [] multiples = countMultiples(array);
        int finalArrayLength = calculateExactLength(multiples,exactNumberOfDuplications);
        Integer [] result = new Integer[finalArrayLength];
        int resultCount = 0;
        int multiplesCount = 0;
        int start = 0;
        int end = multiples[multiplesCount];
        while(multiplesCount < multiples.length) {
            for (int i = start; i < end; i++) {

                if (multiples[multiplesCount] != exactNumberOfDuplications) {
                    result[resultCount] = array[i];
                    resultCount++;
                }

            }
            start = start + multiples[multiplesCount];
            multiplesCount++;
            if(end != array.length){
                end = end + multiples[multiplesCount];
            }

        }
        return result;

    }



    public int calculateExactLength(Integer [] multiples, int exactNumberOfDuplications){
        int count = 0;
        for(int i = 0; i < multiples.length; i++){
            if(multiples[i] != exactNumberOfDuplications){
                count = count + multiples[i];
            }
        }
        return count;
    }

    public int calculateNewLength(Integer [] multiples, int maxNumberOfDuplications){
        int count = 0;
        for(int i = 0; i < multiples.length; i++){
            if(multiples[i] < maxNumberOfDuplications){
                count = count + multiples[i];
            }
        }
        return count;
    }

    public Integer[] countMultiples(Integer [] arr){
        int countMultiples = 1;
        int numGroup = 1;
        int totalCount = 0;
        int start;
        Integer [] duplicates = new Integer[1];

        for(start = 0; start < arr.length; start++){
            for(int j = start+1; j < arr.length; j++){
                if(arr[start] == arr[j]){
                    countMultiples++;
                }
            }
            if (numGroup == 1){
                duplicates[0] = countMultiples;
                totalCount += countMultiples;
                start = totalCount-1;
                countMultiples = 1;
                numGroup++;
            }
            else {
                Integer [] larger = new Integer[duplicates.length+1];
                for(int a = 0; a < duplicates.length; a++){
                    larger[a] =duplicates[a];
                }
                larger[larger.length-1]=countMultiples;
                duplicates = new Integer[larger.length];
                duplicates = larger;
                totalCount += countMultiples;
                start = totalCount-1;
                countMultiples = 1;
            }
        }
        return duplicates;
    }


}
