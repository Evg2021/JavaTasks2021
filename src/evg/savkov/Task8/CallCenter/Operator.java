package evg.savkov.Task8.CallCenter;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Operator {
    private Queue<PhoneCall> phoneCall = new ConcurrentLinkedQueue<>();
    private ArrayList<Employee>[] employees;

    Operator(ArrayList<Employee>[] employees) {
        this.employees = employees;
    }
    public Operator() {
    }

    public Employee getAvailableEmployee(ArrayList<Employee>[] employees) {
        for (ArrayList<Employee> employee : employees) {
            for (Employee value : employee) {
                if (value.isAvailable) return value;
            }
        }
        return null;
    }

    public void setResponderForCall(PhoneCall call) {
        if (getAvailableEmployee(employees) != null) {
            call.setResponder(getAvailableEmployee(employees));
        } else {
            call.state = CallState.QUEUED;
            phoneCall.add(call);
        }
    }

    public void dispatchCall(PhoneCall call) {
        if (phoneCall.isEmpty()) {
            setResponderForCall(call);
        } else {
            int length = phoneCall.size();
            for (int i = 0; i < length; i++) {
                setResponderForCall(phoneCall.element());
                phoneCall.remove();
            }
            phoneCall.add(call);
        }
    }
}
