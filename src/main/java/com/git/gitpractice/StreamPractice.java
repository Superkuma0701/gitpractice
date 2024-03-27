package com.git.gitpractice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        //從現有的陣列建立流
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> numStream = Arrays.stream(arr);
        numStream.forEach(System.out::println);

        //合併現有的流
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream2 = Stream.of(6,7,8);
        Stream<Integer> stream3 = Stream.concat(stream1,stream2);
        stream3.forEach(System.out::println);

        //中間操作
        //篩選
        Stream<Integer> stream = Stream.of(32,55,43,89);
        List<Integer> list1 = stream.filter(cc -> cc%2==0).toList();
        System.out.println("list1:"+list1);

        //地圖（此方法用於透過對原始輸入流的元素執行映射函數來建立新流。也許新流具有不同的資料類型。）
        Stream<Integer> stream4 = Stream.of(21,45,69,10);
        List<Integer>list2 = stream4.map(ss -> ss*2).toList();
        System.out.println("list2:"+list2);

        //distinct（此方法用於透過過濾掉重複項來僅檢索流中的單一元素。）
        Stream<Integer>stream5 = Stream.of(32,32,1,2,1,56,89,89);
        List<Integer>list3 = stream5.distinct().toList();
        System.out.println("list3:"+list3);

        //peek （此方法用於在執行終端操作之前追蹤中間變更。）
        Stream<Integer> stream6 = Stream.of(1,2,3);
        List<Integer>list4 = stream6.map(n -> n*100).peek(System.out::println).toList();
        System.out.println("list4:"+list4);

        //排序
        Stream<Integer> stream7 = Stream.of(34,67,89,10,2,100);
        List<Integer>list5 = stream7.sorted().toList();
        System.out.println("list5"+list5);

        //終端操作
        //foreach
        Stream<Integer> stream8 = Stream.of(23,45,67,90);
        stream8.forEach(System.out::println);

        //count
        Stream<Integer> stream9 = Stream.of(34,24,15);
        System.out.println("stream9count:"+stream9.count());

        //collect（方法用於執行流元素的可變縮減。）
        Stream<Integer> stream10 = Stream.of(33,44,55,66);
        List<Integer> list6 = stream10.filter(ff -> ff%2==1).collect(Collectors.toList());
        System.out.println(list6);

        //min max
        Stream<Integer> stream11 = Stream.of(1000,3,67,457,89);
        int smallest = stream11.min(Integer::compare).get();
        System.out.println("smallest:"+smallest);

        //findAny findFirst
        Stream<Integer> stream12 = Stream.of(36,79,35,70);
        Optional<Integer> opt = stream12.findAny();
        System.out.println("opt:"+opt);
        stream12 = Stream.empty();
        opt = stream12.findFirst();
        System.out.println("opt:"+opt);
    }
}
