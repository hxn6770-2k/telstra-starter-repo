// SimCardActuatorRequest.java
package au.com.telstra.simcardactivator;

public class SimCardActuatorRequest {

    private String iccid;

    public SimCardActuatorRequest() {
    }

    public SimCardActuatorRequest(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
}
