package EP;

public class PilhaIngenua {
    protected final int MAX=100000;
    protected Integer[]pilha;

    PilhaIngenua(){
        pilha = new Integer[MAX];
    }

    void add(Integer newElement){
        int i;
        for(i=0;pilha[i]!=null;i++);
        pilha[i]= newElement;
    }

    int remove(){
        int i;
        for(i=0;pilha[i]!=null;i++);
        int tmp=pilha[i-1];
        pilha[i-1]=null;
        return tmp;
    }
}
