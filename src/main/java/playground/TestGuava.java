package playground;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class TestGuava {
    private static final Joiner joiner = Joiner.on(",").skipNulls();
    public static void main(String[] args) {
        String join = Joiner.on(",").skipNulls().join(Lists.newArrayList("a", "b", null));
        String join2 = Joiner.on(",").useForNull("null").join(Lists.newArrayList("a", "b", null));
        System.out.println(join2);

        for(String element : Splitter.on(",").trimResults().omitEmptyStrings().split(" a,' ', b,, c, ")){
            System.out.println(element);
        }

        System.out.println(CharMatcher.is('o').matchesAllOf( "ooo")); //true
        System.out.println(CharMatcher.is('o').matchesAnyOf( "ooo")); //true
        System.out.println(CharMatcher.is('p').matchesAnyOf( "ooo")); //false
        System.out.println(CharMatcher.is('p').matchesNoneOf( "ooo")); //true

        System.out.println(CharMatcher.is('b').indexIn( "abc")); //1
        System.out.println(CharMatcher.is('b').lastIndexIn( "abcb")); //3
        System.out.println(CharMatcher.is('b').countIn( "abcb")); //2

        System.out.println(CharMatcher.anyOf("b").collapseFrom("abcb", '-' )); // return a-c-
        System.out.println(CharMatcher.anyOf("bc").collapseFrom("abcbc", '-' )); // return a--

        System.out.println(CharMatcher.javaDigit().matchesAllOf("12"));
        System.out.println(CharMatcher.anyOf("-").trimFrom("abc---"));

        List<Integer> list = Ints.asList(1,2,3,4,5);
        System.out.println(Ints.join("|", 1,2,3,4));

        System.out.println("max: " + Ints.max(list.stream().mapToInt(e -> e).toArray()));
        System.out.println("max: " + Ints.min(list.stream().mapToInt(e -> e).toArray()));

        System.out.println(Ints.contains(list.stream().mapToInt(e -> e).toArray(), 6)); // return false

        int[] arr =  Ints.toArray(list);
 ImmutableMap<String, String> map = ImmutableMap.of("name", "sr", "age", "18");
        for(String key: map.keySet()){
            System.out.println(("key: " + key + " value: " + map.get(key)));
        }
        Multiset<String> multiSet = HashMultiset.create();
        multiSet.add("a");
        multiSet.add("a");
        multiSet.add("b");

        System.out.println("size:" + multiSet.size()); //return 3
        System.out.println("count a:" + multiSet.count("a")); //return 2
        ImmutableMap<String, String> map2 = ImmutableMap.of("name", "sr", "age", "18");
        for(String key: map2.keySet()){
            System.out.println(("key: " + key + " value: " + map2.get(key)));
        }

        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("sr", "18");
        multimap.put("sr", "male");

        Collection<String> values = multimap.get("sr");
        System.out.println(values);

        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("sr", "18");

        System.out.println(biMap.get("sr")); //return 18
        System.out.println(biMap.inverse().get("18")); //return sr

        Table<Integer, String, String> table = HashBasedTable.create();
        table.put(1, "sr", "18");
        table.put(2, "aj", "43");
        table.put(3, "lb", "36");

        //use "cell" which is each
        Set<Table.Cell<Integer, String, String>> cellSet = table.cellSet();
        for(Table.Cell cell: cellSet){
            System.out.println( cell.getRowKey() + "," + cell.getColumnKey() + "," + cell.getValue());
        }

        Set<Integer>  rowKeySet = table.rowKeySet();
        System.out.println(rowKeySet);



    }
}
