import java.io.Serializable;

public class Pareja<T1,T2> implements Serializable {
    private  T1 e1;
    private  T2 e2;

    public Pareja(T1 e1,T2 e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public void setE1(T1 e1) {
        this.e1 = e1;
    }

    public void setE2(T2 e2) {
        this.e2 = e2;
    }

    public String toString(){
        return "("+e1+","+e2+")";
    }

}
