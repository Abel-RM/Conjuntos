import java.io.Serializable;
import java.util.*;

public class Conjunto<T> implements Serializable {

    private final HashSet<T> elementos = new HashSet<>();
    private static Conjunto universo;

    public Conjunto(){
    }

    public static void setUniverso(Conjunto c){
        universo = new Conjunto(c.elementos);
    }



    public Conjunto(Collection<T> c){
        elementos.addAll(Serialization.copy(c));
    }


    @Override
    public String toString(){
        String res = "{";
        for(T i : elementos){
            if (i instanceof Collection)
                res += (i.toString().replaceAll("\\[","{").replaceAll("\\]","},"));
            else res += (i+",");
        }
        if (elementos.size()!=0)
            return res.substring(0,res.length()-1)+"}";
        else
            return res+"}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conjunto c = (Conjunto) o;

        return elementos.size() == c.elementos.size() && elementos.containsAll(c.elementos);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public boolean empty(){
        return elementos.size() == 0;
    }

    public boolean contains(T i){
        return elementos.contains(i);
    }

    public boolean subset(Conjunto c){
        return c.elementos.containsAll(elementos);
    }

    public boolean subsetP(Conjunto c){
        return c.elementos.containsAll(elementos) && c.elementos.size() > elementos.size();
    }

    public Conjunto union(Conjunto c){
        HashSet<T> temp = new HashSet<>();
        temp.addAll(c.elementos);
        temp.addAll(elementos);
        return new Conjunto(temp);
    }

    public Conjunto intersection(Conjunto c){
        HashSet<T> temp1 = new HashSet<>();
        HashSet<T> temp2 = new HashSet<>();
        temp1.addAll(elementos);
        temp2.addAll(c.elementos);
        temp1.retainAll(temp2);
        return new Conjunto(temp1);
    }

    public Conjunto difference(Conjunto c){
        HashSet<T> temp1 = new HashSet<>();
        temp1.addAll(elementos);
        temp1.removeAll(c.elementos);
        return new Conjunto(temp1);
    }

    public Conjunto complement(){
        HashSet<T> temp1 = new HashSet<>();
        temp1.addAll( universo.elementos);
        temp1.removeAll(elementos);
        return new Conjunto(temp1);
    }

    public Conjunto clone(){
        return new Conjunto(elementos);
    }

    public Conjunto productC(Conjunto c){
        HashSet<Pareja> temp = new HashSet<>();
        for (T i: elementos){
            for (Object j: c.elementos){
                temp.add(new Pareja(i,j));
            }
        }
        return new Conjunto(temp);
    }


    public Conjunto pow(){
        return  new Conjunto(pow(elementos));
    }

    private  Collection<Conjunto> pow(Collection<T> originalSet){
        HashSet<Conjunto> sets = new  HashSet<>();
        if (originalSet.isEmpty()) {
            Conjunto c = new Conjunto();
            sets.add(c);
            return sets;
        }
        T head = obtenerHead(originalSet);
        HashSet<T> rest = (HashSet<T>) obtenerSubLista(originalSet);
        for (Conjunto set : pow(rest)) {
            HashSet<T> temp = new HashSet<>();
            temp.add(head);
            temp.addAll(set.elementos);
            Conjunto newC = new Conjunto(temp);
            sets.add(newC);
            sets.add(set);
        }
        return sets;
    }

    private Collection<T> obtenerSubLista(Collection<T> list){
        HashSet<T> temp1 = new HashSet<>();
        boolean p = true;
        for (T i: list){
            if(!p){
                temp1.add(i);
            }
            p = false;
        }
        return temp1;
    }

    private T obtenerHead(Collection<T> list){
        for (T i: list){
            return i;
        }
        return null;
    }

}
