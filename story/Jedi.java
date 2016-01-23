package story;
public class Jedi {

    private int hp;
    private String name;

    //Constructor
    public Jedi() {
	hp = 100;
	name = "Luke";
    }

    //Accessors
    public int getHP() {
	return hp;
    }

    public String getName() {
	return name;
    }

    //Modifiers
    public void setHP(int new) {
	hp = new;
    }

    public void setName(String new) {
	name = new;
    }

}//end of class Character
