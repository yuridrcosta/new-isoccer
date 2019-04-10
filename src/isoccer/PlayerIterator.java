package isoccer;

import java.util.ArrayList;

public class PlayerIterator implements Iterator {

    private ArrayList<Player> players;
    private int position = 0;

    public PlayerIterator(ArrayList<Player> players) {
        this.players = players;
    }
    
    @Override
    public boolean hasNext() {
        return position+1 <= players.size();
    }

    @Override
    public Player next() {
        Player nextPlayer = players.get(position);
        position++;
        return nextPlayer;
    }
    
}