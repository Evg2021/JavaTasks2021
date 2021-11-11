package evg.savkov.Task8.CallCenter;

public class CallCenterTask {
    public static void main(String[] args) {
        Operator operator = new Operator(CallCenter.seedEmployees());
        PhoneCall phoneCall = new PhoneCall();
        operator.dispatchCall(phoneCall);
    }
}
