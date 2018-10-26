import javax.sound.midi.Soundbank;
import java.lang.Exception;
public class ArrayList implements List {


    public static Object[] list = new Object[10];
    public static int size;
    public static int end = -1;


    @Override
    public void add(Object obj) {
        if(list[list.length-1]!=null)
            growList();
        end++;
        list[end] = obj;
        size++;
    }

    @Override
    public void add(int pos, Object obj) {
        if(list[list.length-1]!=null)
            growList();
        int i = end;
        if(list[pos] != null) {
            while (list[i] != null) {
                list[i + 1] = list[i];
                i--;
            }
        }
        list[pos] = obj;
        end++;
        size++;
    }

    @Override
    public Object remove(int pos) {
        Object temp = list[pos];
        int i = pos;
        while (pos<=end){
            try {
                list[pos] = list[pos+1];
                pos++;
            }
            catch (Exception e){
                System.out.println("Last index out of bounds- add null manually");
                list[pos] = null;
            }
        }
        end--;
        size--;
        return temp;
    }

    @Override
    public Object get(int pos) {
        if (pos > size-1){
            System.out.println("Invalid index");
            return null;
        }
        return list[pos];
    }

    @Override
    public int size() {
        return size;
    }

    public void growList(){
        Object[] newArray = new Object[list.length*2];
        int index = 0;
        for (Object item : list){
            newArray[index++] = item; //copy each element of arr into newArr
        }
        list = newArray;
    }

}
