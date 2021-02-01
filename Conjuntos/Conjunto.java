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
        Conjunto<T> c = (Conjunto) o;

        for (T elemento: elementos){
            int count = 0;
            for (T item: c.elementos){
                if (item.equals(elemento))
                    count++;
            }
            if (count == 0)
                return false;
        }

        return elementos.size() == c.elementos.size();
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

    public boolean subset(Conjunto<T> c){
        return c.elementos.containsAll(elementos);
    }

    public boolean subsetP(Conjunto<T> c){
        return c.elementos.containsAll(elementos) && c.elementos.size() > elementos.size();
    }

    public Conjunto<T> union(Conjunto<T> c){
        HashSet<T> temp = new HashSet<>();
        temp.addAll(c.elementos);
        temp.addAll(elementos);
        return new Conjunto(temp);
    }

    public Conjunto<T> intersection(Conjunto<T> c){
        HashSet<T> temp1 = new HashSet<>();
        HashSet<T> temp2 = new HashSet<>();
        temp1.addAll(elementos);
        temp2.addAll(c.elementos);
        temp1.retainAll(temp2);
        return new Conjunto(temp1);
    }

    public Conjunto<T> difference(Conjunto<T> c){
        HashSet<T> temp1 = new HashSet<>();
        temp1.addAll(elementos);
        temp1.removeAll(c.elementos);
        return new Conjunto(temp1);
    }

    public Conjunto<T> complement(){
        HashSet<T> temp1 = new HashSet<>();
        temp1.addAll( universo.elementos);
        temp1.removeAll(elementos);
        return new Conjunto(temp1);
    }

    public Conjunto<T> clone(){
        return new Conjunto(elementos);
    }

    public Conjunto<Pareja> productC(Conjunto c){
        HashSet<Pareja> temp = new HashSet<>();
        for (T i: elementos){
            for (Object j: c.elementos){
                temp.add(new Pareja(i,j));
            }
        }
        return new Conjunto(temp);
    }


    public Conjunto<T> pow(){
        return  new Conjunto(pow(elementos));
    }

    private  Collection<Conjunto<T>> pow(Collection<T> originalSet){
        HashSet<Conjunto<T>> sets = new  HashSet<>();
        if (originalSet.isEmpty()) {
            Conjunto<T> c = new Conjunto();
            sets.add(c);
            return sets;
        }
        T head = obtenerHead(originalSet);
        HashSet<T> rest = (HashSet<T>) obtenerSubLista(originalSet);
        for (Conjunto<T> set : pow(rest)) {
            HashSet<T> temp = new HashSet<>();
            temp.add(head);
            temp.addAll(set.elementos);
            Conjunto<T> newC = new Conjunto(temp);
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
