package evg.savkov.Task8.CallCenter;

abstract public class Employee {
    protected String firstName;
    protected String lastName;
    public boolean isAvailable;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        isAvailable = true;
    }

    public Employee() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public void answerPhoneCall(PhoneCall phoneCall) {
        isAvailable = false;
        phoneCall.state = CallState.ANSWERED;
        System.out.println("Звонок был принят");
    }


}
