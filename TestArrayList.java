import java.util.*;

public class TestArrayList
{
   public static void main(String[] args)
   {
      ArrayList<String> foo = new ArrayList<String>();
      String one = "Bonjour";
      foo.add("Hello");
      foo.add("world");
      foo.add("Jack");
      foo.add(one);
      foo.add("!!!!");
      foo.add("!");
      System.out.println("Original foo: " + foo);
      foo.remove(one);
      System.out.println("Removed foo: " + foo);
      foo.add(one);
      System.out.println("Re-ordered foo: " + foo);
      //foo.add("Jack");
      System.out.println(foo);
      foo.remove(3);
      System.out.println(foo);
      System.out.println(foo);
      System.out.println("The array now has " + foo.size() + " elements");
      System.out.println("The item at index 2 is " + foo.get(2));
      foo.set(1, "universe");
      System.out.println(foo);
//       foo.set(4, "Does this work?");
//       System.out.println(foo);
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(4); // 4 is boxed to an Integer with value 4
      list.add(6);
      int product = list.get(0) * list.get(1);
      System.out.println ("product = " + product);
      list.add(5);
      list.add(10);
      list.add(0);
      list.add(-1);
      list.add(4);
      System.out.println("before " + list);
      Collections.sort(list);
      System.out.println("after " + list);
      Collections.shuffle(list);
      System.out.println ("shuffled " + list);
//       ArrayList<String> fooExtraLarge = new ArrayList<String>(-4);
//       foo.clear();
//       System.out.println(foo);
   }
}