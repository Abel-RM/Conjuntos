import javax.swing.plaf.IconUIResource;
import java.util.*;

public class UsaConjuntos {
    public static void main(String[] args) {
        HashSet<Integer> list = new HashSet<>();
        HashSet<Integer> list2 = new HashSet<>();

        list.addAll(new ArrayList<>(Arrays.asList(1,2)));
        list2.addAll(new ArrayList<>(Arrays.asList(1,2,3)));

        Conjunto c = new Conjunto(list);
        Conjunto c2 = new Conjunto(list2);
        Conjunto v = new Conjunto();
        Conjunto.setUniverso(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
        System.out.println("conjunto c:");
        System.out.println(c);
        System.out.println("conjunto c2:");
        System.out.println(c2);
        System.out.println("El conjunto c y c2 son iguales:");
        System.out.println(c.equals(c2));
        System.out.println("El conjunto c esta vacio:");
        System.out.println(v.empty());
        System.out.println("El conjunto c contiene :(3)");
        System.out.println(c.contains(3));
        System.out.println("El conjunto c es subconjunto de c2:");
        System.out.println(c.subset(c2));
        System.out.println("El conjunto c es subconjunto propio de c2:");
        System.out.println(c.subsetP(c2));
        System.out.println("La union de c y c2 es:");
        System.out.println(c.union(c2));
        System.out.println("La Intersección de c y c2 es:");
        System.out.println(c.intersection(c2));
        System.out.println("La diferencia de c2 y c es:");
        System.out.println(c2.difference(c));
        System.out.println("El complemento de c con c2 es:");
        System.out.println(c.complement());
        System.out.println("El producto cartesiano de c con c2 es:");
        System.out.print("{");
        for (Pareja pareja: c.productC(c2)){
            System.out.print(pareja);
        }
        System.out.println("}");
        System.out.println("El conjunto clone de c es:");
        System.out.println(c.clone());
        System.out.println("El conjunto potencia de c es:");
        int count = 0;
        System.out.print("{");
        HashSet<Conjunto> potencia= (HashSet<Conjunto>) c.pow();
        for (Conjunto conjunto: potencia){
            System.out.print(conjunto);
            count++;
            if (count <potencia.size() )
                System.out.print(",");
        }
        System.out.println("}");

        Conjunto n =c.union(c2);
        System.out.println(n);
        c = n.complement();
        System.out.println(c);
    }
}
