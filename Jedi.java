//package story;
public class Jedi {
    private int hp;
    private String name;

    //constructor
    public Jedi() {
	hp = 100;
	name = "Luke";
    }

    //accessors
    public int getHP() {
	return hp;
    }

    public String getName() {
	return name;
    }

    //mutators
    public void setHP(int newHP) {
	hp = newHP;
    }

    public void setName(String newName) {
	name = newName;
    }
} //end of class Jedi
