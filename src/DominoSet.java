import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class DominoSet {

    //Programmer writes all other necessary code to this class

    //Given shuffle method
    //setOfDominoes is a List of Domino
    //rotate is a method in Domino
    //this is the only method allowed to use indicies.

    ArrayList<Domino>setOfDominoes = new ArrayList<>();
    ArrayList<Domino> removedList = new ArrayList<>();
    int removedCount = 0;

    public DominoSet(int bound){
        for(int i = 0; i <= bound; i++){
            for(int j = i; j <= bound; j++){
                setOfDominoes.add(new Domino(i,j));
            }
        }
    }

    public void shuffle(int randSeed) {
        Random rand = new Random(randSeed);
        for(int i=0; i<setOfDominoes.size(); i++)
        {
            if(rand.nextBoolean())
                setOfDominoes.get(i).rotate();
            int k = rand.nextInt(setOfDominoes.size());
            Domino temp = setOfDominoes.get(k);
            setOfDominoes.set(k,setOfDominoes.get(i));
            setOfDominoes.set(i, temp);
        }
    }

    public void sortList(){
        ListIterator<Domino>iter = setOfDominoes.listIterator();
        while(iter.hasNext()){
            Domino first = iter.next();
            if(iter.hasNext()){
                Domino second = iter.next();
                if(first.getSecondNum() == second.getFirstNum()){
                    iter.previous();
                }
                else if(first.getSecondNum() ==  second.getSecondNum()){
                    second.rotate();
                    iter.previous();
                } else {
                    removedList.add(second);
                    iter.remove();
                    iter.previous();
                }
            }
        }
        Domino lastDomino = iter.previous();
        ListIterator<Domino> iter2 = removedList.listIterator();
        boolean game = false;
        while(!game) {
            boolean firstTest = false;
            boolean secondTest = false;
            while (iter2.hasNext()) {
                Domino temp = iter2.next();
                if (temp.getFirstNum() == lastDomino.getSecondNum()) {
                    setOfDominoes.add(temp);
                    iter2.remove();
                    firstTest = true;
                } else if (temp.getSecondNum() == lastDomino.getSecondNum()) {
                    temp.rotate();
                    setOfDominoes.add(temp);
                    iter2.remove();
                    secondTest = true;
                }
            }
            iter2 = removedList.listIterator();
            game = firstTest||secondTest;
        }
        removedCount = removedList.size();
    }

    public int getRemovedCount() {
        return removedCount;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < setOfDominoes.size(); i++){
            str += setOfDominoes.get(i).toString();
        }
        return str;
    }
}