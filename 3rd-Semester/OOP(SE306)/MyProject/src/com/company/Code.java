package com.company;

import java.util.*;

public class Code {
    public void start() {
        int[] array = new int[10];
        Arrays.fill(array, 9);
        Arrays.sort(array);

        // Arrays.asList(list);

        int[] newArray = new int[array.length];
        System.arraycopy(newArray,0,  array, 0, array.length);

        for(int obj: array) {
            // do
        }

        int pos = Arrays.binarySearch(array, 89);

        boolean equal = Arrays.equals(array, newArray);
    }

    public void iterator() {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);

        // list.subList(0, 2).clear();
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        ListIterator<Integer> listIterator1 = list.listIterator(0);
        // listIterator.hasPrevious();
        // listIterator.hasNext()
        System.out.println(listIterator.previous());
        System.out.println(listIterator1.next());


        // list.remove(3);
        // list.remove((Integer)3);

        printCollection(list);

        // remove 1
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            // this iterator becomes invalid if collection is modified
            // list.remove(1);
            if(iterator.next() == 1) {
                iterator.remove();
            }
        }

        printCollection(list);
    }

    public <T> void printCollection(Collection<T> collection) {
        for(T obj: collection) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Code code = new Code();
        code.iterator();

        List<Integer> links = new LinkedList<>();
        Integer[] array = links.toArray(new Integer[links.size()]);

        List<String> vector = new Vector<>();

//        Collections.disjoint();

        Set<Integer> set = new TreeSet<>();
    }
}













