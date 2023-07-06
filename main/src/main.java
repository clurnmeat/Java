import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

import java.util.LinkedList;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import static java.lang.foreign.MemorySegment.NULL;

public class main {
    private int data;
    private main next;
    private LinkedList<Integer> nums;



    main(int data) {
        this.data = data;
        this.next = null;
    }
    main constructLinkedList(){
        main head = null;
        main tail = null;
        nums = new LinkedList<Integer>();

        for(int i=1; i<=3; i++){
            main node = new main(i);
            if(head == null){
                head = node;
            } else {
                tail.setnext();
            }
        }

        return head;
    }


    public static void main(String[]args){

    }
}
