package Ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopPlayers implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4375652349062258560L;
	private List<Player> ranking;
	private final Integer maxTop = 5;
	
	public TopPlayers() {
		ranking = new ArrayList<Player>(maxTop);
	}
	
	public void addPlayer(Player p) {
		ranking.add(p);
		Collections.sort(ranking, Collections.reverseOrder());
		if(ranking.size()>maxTop) 
			ranking.remove(ranking.size()-1);
	}
	
	public List<Player> getTopPlayers() {
		return ranking;
	}
}