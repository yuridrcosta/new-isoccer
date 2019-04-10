
package isoccer;

import java.util.ArrayList;
public class PartnerIterator implements Iterator{

    private ArrayList<Partner> persons;
    private int position = 0;

    public PartnerIterator(ArrayList<Partner> persons) {
        this.persons = persons;
    }
    
    @Override
    public boolean hasNext() {
        return position+1 <= persons.size();
    }

    @Override
    public Partner next() {
        Partner nextPerson = persons.get(position);
        position++;
        return nextPerson;
    }
    
}
