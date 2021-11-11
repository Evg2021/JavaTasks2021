package evg.savkov.Task8.CallCenter;

import java.util.ArrayList;

public class CallCenter {
    public static ArrayList<Employee>[] seedEmployees() {
        ArrayList<Operator> operators = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Director> director = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            operators.add(new Operator());
        }
        for (int i = 0; i < 4; i++) {
            managers.add(new Manager());
        }
        for (int i = 0; i < 2; i++) {
            director.add(new Director());
        }

        return new ArrayList[] { operators, managers, director };
    }
}
