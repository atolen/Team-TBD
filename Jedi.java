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
    public void setHP(int newHP) {
	hp = newHP;
    }

    public void setName(String newName) {
	name = newName;
    }

}//end of class Jedi
