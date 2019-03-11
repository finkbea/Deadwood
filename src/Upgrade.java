import java.util.ArrayList;

public class Upgrade{

  private int level;
  private int currency;
  private int amount;
  private ArrayList<Integer> area;

  public Upgrade(int l, String c, int a, ArrayList<Integer> ar){
    this.level=l;
    this.amount=a;
    this.area=ar;
    if (c.equals("dollar")){
      this.currency=0;
    }
    else if (c.equals("credit")){
      this.currency=1;
    }
  }

    public ArrayList<Integer> getArea(){
	return area;
    }
}
