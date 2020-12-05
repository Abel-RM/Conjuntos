import javax.swing.plaf.IconUIResource;
import java.util.*;

public class UsaConjuntos {
    public static void main(String[] args) {
        ArrayList col = new ArrayList<>();
        col.add(3);
        col.add(true);
        col.add("Hola");
        col.add(Arrays.asList(4,"adios",false));
        Conjunto c = new Conjunto(col);

        ArrayList col2 = new ArrayList<>();
        col2.add(3);
        col2.add(8);
        col2.add(true);
        col2.add("Hola");
        col2.add(Arrays.asList(4,"adios",false));
        Conjunto c2 = new Conjunto(col2);

        Conjunto vacio = new Conjunto();

        Conjunto c3 = new Conjunto(Arrays.asList(1,true,2,false,3));

        Conjunto c4 = new Conjunto(Arrays.asList(4,5));

        Conjunto c5 = new Conjunto(Arrays.asList(1,3,5));

        Conjunto.setUniverso(new Conjunto(Arrays.asList(3,4,5,6,"javac")));


        System.out.println("----------------------------------");
        System.out.println("Los conjuntos "+c+" "+c2+" son iguales: "+c.equals(c2)+"\n");
        System.out.println("El conjunto: "+c+" contiene " +Arrays.asList(4,"scarlet",false)+": "+c.contains(Arrays.asList(4,"scarlet",false))+"\n");
        System.out.println("El conjunto "+c+" esta vacio: "+c.empty()+"\n");
        System.out.println("El conjunto "+c+" es subconjunto de "+c2+": "+vacio.subset(c2)+"\n");
        System.out.println("El conjunto "+c+" es subconjunto propio de "+c2+": "+c.subsetP(c2)+"\n");
        System.out.println("La union del conjunto "+c+" y el conjunto "+c3+" es: "+c.union(c3)+"\n");
        System.out.println("La interseccion del conjunto "+c+ " el conjunto "+c3+" es: "+c.intersection(c3)+"\n");
        System.out.println("La diferencia del conjunto "+c+" y el conjunto "+c3+" es: "+c.difference(c3)+"\n");
        System.out.println("El complemento del conjunto "+c3+" es: "+c3.complement()+"\n");
        System.out.println("El producto carteciano del conjunto "+c3+" y el conjunto "+c4+" es:\n "+c3.productC(c4)+"\n");
        System.out.println("El conjunto clone de "+c3 +" es: "+c3.clone()+"\n");
        System.out.println("El conjunto potencia de "+c5+" es: "+c5.pow());
    }
}
