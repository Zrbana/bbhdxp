package DataStructs.Lists;

import java.util.List;

public class MergeSortedArrayList {
    public static void main(String[] args) {

    }


    public static void merge(List<Integer> listA,List<Integer> listB,List<Iterable> listC){
        int pa = 0;//listA的下标
        int pb = 0;//listB的下标

        while(pa<listA.size() && pb<listB.size()){
            if(listA.get(pa) <= listB.get(pb)){
                listC.add(listA.get(pa++));
            }else{
                listC.add(listB.get(pb++));
            }
        }
        while(pa<listA.size()){
            listC.add(listA.get(pa++));
        }
        while(pb < listB.size()){
            listC.add(listB.get(pb++));
        }
    }

}
