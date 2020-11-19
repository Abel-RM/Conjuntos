import java.util.*;

public class Conjunto {

    private HashSet<Integer> elementos = new HashSet<>();
    private static HashSet<Integer> universo= new HashSet<>();

    public Conjunto(){
    }

    public static void setUniverso(Collection c){
        universo.addAll(c);
    }



    public Conjunto(Collection c){
        elementos.addAll(c);
    }

    private Collection<Integer> getElementos() {
        return elementos;
    }

    @Override
    public String toString(){
        String res = "{";
        int count = 0;
        for(Integer i : elementos){
            res += i;
            count++;
            if (count < elementos.size())
                res +=",";

        }
       return res+"}";
    }



    public boolean equals(Conjunto c){
        return elementos.size() == c.getElementos().size() && elementos.containsAll(c.getElementos());
    }

    public boolean empty(){
        return elementos.size() == 0;
    }

    public boolean contains(Integer i){
        return elementos.contains(i);
    }

    public boolean subset(Conjunto c){
        return c.getElementos().containsAll(elementos);
    }

    public boolean subsetP(Conjunto c){
        return c.getElementos().containsAll(elementos) && c.getElementos().size() > elementos.size();
    }

    public Conjunto union(Conjunto c){
        HashSet<Integer> temp = new HashSet<>();
        temp.addAll(c.getElementos());
        temp.addAll(elementos);
        return new Conjunto(temp);
    }

    public Conjunto intersection(Conjunto c){
        HashSet<Integer> temp1 = new HashSet<>();
        HashSet<Integer> temp2 = new HashSet<>();
        temp1.addAll(elementos);
        temp2.addAll(c.getElementos());
        temp1.retainAll(temp2);
        return new Conjunto(temp1);
    }

    public Conjunto difference(Conjunto c){
        HashSet<Integer> temp1 = new HashSet<>();
        temp1.addAll(elementos);
        temp1.removeAll(c.getElementos());
        return new Conjunto(temp1);
    }

    public Conjunto complement(){
        HashSet<Integer> temp1 = new HashSet<>();
        temp1.addAll(universo);
        temp1.removeAll(elementos);
        return new Conjunto(temp1);
    }


    public Collection<Pareja> productC(Conjunto c){
        HashSet<Pareja> temp = new HashSet<>();
        for (Integer i: elementos){
            for (Integer j: c.getElementos()){
                temp.add(new Pareja(i,j));
            }
        }
        return temp;
    }

    public Conjunto clone(){
        return new Conjunto(elementos);
    }

    public Collection<Conjunto> pow(){
        return pow(elementos);
    }

    private  Collection<Conjunto> pow(Collection<Integer> originalSet){
        HashSet<Conjunto> sets = new  HashSet<>();
        if (originalSet.isEmpty()) {
            Conjunto c = new Conjunto();
            sets.add(c);
            return sets;
        }
        Integer head = obtenerHead(originalSet);
        HashSet<Integer> rest = (HashSet<Integer>) obtenerSubLista(originalSet);
        for (Conjunto set : pow(rest)) {
            HashSet<Integer> temp = new HashSet<>();
            temp.add(head);
            temp.addAll(set.getElementos());
            Conjunto newC = new Conjunto(temp);
            sets.add(newC);
            sets.add(set);
        }
        return sets;
    }

    private Collection<Integer> obtenerSubLista(Collection<Integer> list){
        HashSet<Integer> temp1 = new HashSet<>();
        boolean p = true;
        for (Integer i: list){
            if(!p){
                temp1.add(i);
            }
            p = false;
        }
        return temp1;
    }

    private Integer obtenerHead(Collection<Integer> list){
        for (Integer i: list){
            return i;
        }
        return null;
    }


}
