package evg.savkov.Task8.CallCenter;

enum CallState {
    ANSWERED, QUEUED
}
public class PhoneCall {
    public CallState state;
    //public Operator operator;

    public void setResponder(Employee employee) {
        employee.answerPhoneCall(this);
    }
}
