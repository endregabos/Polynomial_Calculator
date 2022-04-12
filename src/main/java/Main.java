
import controller.Controller;
import model.Model;
import view.View;

public class Main {
    public static void main(String[] args) {
        Model calcModel = new Model();
        View calcView = new View(calcModel);
        Controller calcController = new Controller(calcModel, calcView);

    }
}