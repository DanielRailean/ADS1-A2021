import java.util.ArrayList;
import java.util.List;

public class SudokuSmallSquare
{
  public List<Integer> items;
  public SudokuSmallSquare()
  {
    List<Integer> returned = new ArrayList<>();
    for(int i=0;i<9;i++){
      returned.add(-1);
    }
    this.items =  returned;
    System.out.println(items);
  }

  public boolean isValid(){
    return isValid(items);
  }

  private boolean isValid(List<Integer> items){
    for(int i=0;i<items.size();i++){
      List<Integer> local = new ArrayList<>(items);
      Integer checked = items.get(i);
      local.remove(checked);
        if(local.contains(checked)&&checked!=-1){
          return false;
        }
    }
    return true;
  }
  public boolean tryInsert(int position,int value){
    List<Integer> local = (List<Integer>) items.subList(0,items.size());
    local.set(position,value);
    return isValid(local);
  }
  public void insert(int position,int value){
    items.set(position-1,value);
  }
  public String print(){
    String returned = "_______\n";
    for(int i=0; i<items.size();i++){
      if(i==2||i==5||i==8){
        if(items.get(i)==-1) returned +=" \n";
        else returned +=items.get(i)+"\n";
      }else if(items.get(i)==-1){
        returned +="  ";
      }else{
        returned +=items.get(i)+" ";
      }
      //      if(i%2==0&& items.get(i)!=-1){
//        returned +=items.get(i)+"\n";
//      }else if(items.get(i)==-1){
//        returned +=" ";
//      }else{
//        returned +=items.get(i)+" ";
//      }
    }
    returned+="_______ ";
    System.out.println(returned);
    return returned;
  }

}
