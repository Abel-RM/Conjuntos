import java.util.*;

public class Conjunto {

    private HashSet<ArrayList<Integer>> elementos = new HashSet<>();

    public Conjunto(){
    }

    public Conjunto(HashSet<ArrayList<Integer>> c){
        elementos.addAll(c);
    }

    public HashSet<ArrayList<Integer>> getElementos() {
        return elementos;
    }

    @Override
    public String toString(){
        String res = "{";
        int count = 0;
        int count2 = 0;
        for(ArrayList<Integer> h : elementos){
            count++;
            if (h.size()>1){
                res += "(";
            }
            for (Integer i : h){
                count2++;
                res += i;

                if ((h.size()>1) && (count2 < h.size()))
                    res += ",";
            }
            count2 = 0;
            if (h.size()>1)
                res += ")";

            if (count < elementos.size())
                res += ",";
        }
       return res+"}";
    }

    public boolean equals(Conjunto c){
        if(elementos.size() == c.getElementos().size() && elementos.containsAll(c.getElementos()) )
            return true;
        else return false;
    }

    public boolean empty(){
        if (elementos.size() == 0)
            return true;
        else return false;
    }

    public boolean contains(ArrayList<Integer> i){
        if (elementos.contains(i))
            return true;
        else return false;
    }

    public boolean subset(Conjunto c){
        if (c.getElementos().containsAll(elementos) )
            return true;
        else return false;
    }

    public boolean subsetP(Conjunto c){
        if (c.getElementos().containsAll(elementos) && c.getElementos().size() > elementos.size())
            return true;
        else return false;
    }

    public Conjunto union(Conjunto c){
        HashSet<ArrayList<Integer>> temp = new HashSet<>();
        temp.addAll(c.getElementos());
        temp.addAll(elementos);
        return new Conjunto(temp);
    }

    public Conjunto intersection(Conjunto c){
        HashSet<ArrayList<Integer>> temp1 = new HashSet<>();
        HashSet<ArrayList<Integer>> temp2 = new HashSet<>();
        temp1.addAll(elementos);
        temp2.addAll(c.getElementos());
        temp1.retainAll(temp2);
        return new Conjunto(temp1);
    }

    public Conjunto difference(Conjunto c){
        HashSet<ArrayList<Integer>> temp1 = new HashSet<>();
        temp1.addAll(elementos);
        temp1.removeAll(c.getElementos());
        return new Conjunto(temp1);
    }

    public Conjunto complement(Conjunto c){
        HashSet<ArrayList<Integer>> temp1 = new HashSet<>();
        temp1.addAll(c.getElementos());
        temp1.removeAll(elementos);
        return new Conjunto(temp1);
    }

    public Conjunto productC(Conjunto c){
        HashSet<ArrayList<Integer>> temp1 = new HashSet<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for (ArrayList<Integer> i: elementos){
            for (ArrayList<Integer> h: c.getElementos()){
                temp2.addAll(i);
                temp2.addAll(h);
                temp1.add(temp2);
                temp2 = new ArrayList<>();
            }
        }
        return new Conjunto(temp1);
    }

    public Conjunto clone(){
        return new Conjunto(elementos);
    }

    public Conjunto pow(){
        return new Conjunto(pow(elementos));
    }

    private  HashSet<ArrayList<Integer>> pow(HashSet<ArrayList<Integer>> originalSet){
        HashSet<ArrayList<Integer>> sets = new  HashSet<>();
        if (originalSet.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<>();
            sets.add(arr);
            return sets;
        }
        ArrayList<Integer> head = obtenerHead(originalSet);
        HashSet<ArrayList<Integer>> rest = obtenerSubLista(originalSet);
        for (ArrayList<Integer> set : pow(rest)) {
            ArrayList<Integer> newSet = new ArrayList<>();
            newSet.addAll(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    private HashSet<ArrayList<Integer>> obtenerSubLista(HashSet<ArrayList<Integer>> list){
        HashSet<ArrayList<Integer>> temp1 = new HashSet<>();
        boolean p = true;
        for (ArrayList<Integer> i: list){
            if(!p){
                temp1.add(i);
            }
            p = false;
        }
        return temp1;
    }

    private ArrayList<Integer> obtenerHead(HashSet<ArrayList<Integer>> list){
        for (ArrayList<Integer> i: list){
            return i;
        }
        return null;
    }
}
