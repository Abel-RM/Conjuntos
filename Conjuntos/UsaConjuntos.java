import java.util.*;

public class UsaConjuntos {

    public static void main(String[] args) {

        Conjunto<Integer> c1 = new Conjunto<>(Arrays.asList(1, 2, 3));

        Conjunto<Integer> c2 = new Conjunto<>(Arrays.asList(1,2,3,4,5));

        Persona p1 = new Persona("prueba1", 23);
        Persona p2 = new Persona("prueba2", 20);

        Persona p3 = new Persona("prueba1", 23);
        Persona p4 = new Persona("prueba2", 20);

        Conjunto<Persona> c3 = new Conjunto<>(Arrays.asList(p1,p2));

        Conjunto<Persona> c4 = new Conjunto<>(Arrays.asList(p3,p4));

        Conjunto<String> c5 = new Conjunto<>(Arrays.asList("hola", "adios"));

        Conjunto.setUniverso(new Conjunto<>(Arrays.asList(1,2,3,4,5,6,7,8,9)));

        System.out.println("El conjunto c1 esta vacio: "+c1.empty());

        System.out.println("El conjunto c1 contiene a hola: "+c5.contains("hola"));

        System.out.println("C1 es un subconjunto de c2: "+c1.subset(c2));

        System.out.println("C1 es un subconjunto propio de c2: "+c1.subsetP(c2));

        System.out.println("la union de c1 y c2 es: "+ c1.union(c2));

        System.out.println("La interseccion de c1 y c2 es: "+c1.intersection(c2));

        System.out.println("La diferencia de c1 y c2 es: "+c2.difference(c1));

        System.out.println("El complemento de c1 es: "+ c1.complement());

        System.out.println("El clone de c1 es: "+c1.clone());

        System.out.println("El producto de c1 y c2 es: "+c1.productC(c5));

        System.out.println("La potencia de c1 es: "+c1.pow());


    }
}
