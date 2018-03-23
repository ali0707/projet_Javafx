package Controllers;

import Entities.Child;
import javafx.collections.ObservableList;
import Services.ChildService;

public class ChildController {

    public void addChild(){
        Child c = new Child(3, 2, "fedi", 2, true, 21);
        ChildService cs = new ChildService();

        cs.addChild(c);
    }

    public void deleteChild(int id){
        ChildService cs = new ChildService();
        cs.deleteObject(id,"Child");
    }

    public void showChild(int id){
        ChildService cs = new ChildService();
        Child c = cs.findChild(id);
        System.out.println(c);
    }

    public void updateChild(int id) {
        ChildService cs = new ChildService();
        Child c = cs.findChild(id);
        c.setName("new came");
        cs.updateChild(c);
        c = cs.findChild(id);
        System.out.print(c);
    }

    public void listChilds(){
        ChildService cs = new ChildService();
        System.out.println("Liste des enfants");
        ObservableList<Child> cartoons = cs.findAll();
        for (Child c : cartoons){
            System.out.println(c);
        }
    }

    public void listMyKids(int id) {
        ChildService cs = new ChildService();
        ObservableList<Child> mykids = cs.findMykids(id);
        System.out.println("Liste des enfants");
        for (Child c : mykids){
            System.out.println(c);
        }
    }

}
