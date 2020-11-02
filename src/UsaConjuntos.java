import java.util.*;

public class UsaConjuntos {
    public static void main(String[] args) {
        HashSet<ArrayList<Integer>> list = new HashSet<>();
        HashSet<ArrayList<Integer>> list2 = new HashSet<>();

        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(3)));
        list.add(new ArrayList<>(Arrays.asList(4)));
        list2.add(new ArrayList<>(Arrays.asList(1)));
        list2.add(new ArrayList<>(Arrays.asList(2)));
        list2.add(new ArrayList<>(Arrays.asList(3)));
        list2.add(new ArrayList<>(Arrays.asList(4)));
        list2.add(new ArrayList<>(Arrays.asList(5)));
        list2.add(new ArrayList<>(Arrays.asList(6)));

        Conjunto c = new Conjunto(list);
        Conjunto c2 = new Conjunto(list2);
        System.out.println("conjunto c:");
        System.out.println(c);
        System.out.println("conjunto c2:");
        System.out.println(c2);
        System.out.println("El conjunto c y c2 son iguales:");
        System.out.println(c.equals(c2));
        System.out.println("El conjunto c esta vacio:");
        System.out.println(c.empty());
        System.out.println("El conjunto c contiene :(3)");
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(3);
        System.out.println(c.contains(temp));
        System.out.println("El conjunto c es subconjunto de c2:");
        System.out.println(c.subset(c2));
        System.out.println("El conjunto c es subconjunto propio de c2:");
        System.out.println(c.subsetP(c2));
        System.out.println("La union de c y c2 es:");
        System.out.println(c.union(c2));
        System.out.println("La Intersección de c y c2 es:");
        System.out.println(c.intersection(c2));
        System.out.println("La diferencia de c2 y c es:");
        System.out.println(c.difference(c2));
        System.out.println("El complemento de c con c2 es:");
        System.out.println(c.complement(c2));
        System.out.println("El producto cartesiano de c con c2 es:");
        System.out.println(c.productC(c2));
        System.out.println("El conjunto clone de c es:");
        System.out.println(c.clone());
        System.out.println("El conjunto potencia de c es:");
        System.out.println(c.pow());
    }
}
