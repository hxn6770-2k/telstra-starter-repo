package au.com.telstra.simcardactivator;

public class SimCardRequest {

    private String iccid;
    private String customerEmail;

    // Default constructor
    public SimCardRequest() {
    }

    // Parameterized constructor
    public SimCardRequest(String iccid, String customerEmail) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }

    // Getter for iccid
    public String getIccid() {
        return iccid;
    }

    // Setter for iccid
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    // Getter for customerEmail
    public String getCustomerEmail() {
        return customerEmail;
    }

    // Setter for customerEmail
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
