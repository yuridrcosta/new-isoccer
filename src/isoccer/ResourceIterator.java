
package isoccer;

import java.util.ArrayList;
public class ResourceIterator implements Iterator{

    private ArrayList<Resource> resources;
    private int position = 0;

    public ResourceIterator(ArrayList<Resource> resources) {
        this.resources = resources;
    }
    
    @Override
    public boolean hasNext() {
        return position+1 <= resources.size();
    }

    @Override
    public Resource next() {
        Resource nextResource = (Resource) resources.get(position);
        position++;
        return nextResource;
    }
}
