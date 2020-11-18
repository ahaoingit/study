package CRUD.entity;

import java.io.Serializable;

/**
 * (Crm)实体类
 *
 * @author makejava
 * @since 2020-08-31 00:52:28
 */
public class Crm implements Serializable {
    private static final long serialVersionUID = 564487035884036350L;

    private String id;

    private String initiativePhone;

    private String passivityPhone;

    private String customerId;

    private String callTime;

    private String sumTime;

    private String waiterId;

    private String callResult;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitiativePhone() {
        return initiativePhone;
    }

    public void setInitiativePhone(String initiativePhone) {
        this.initiativePhone = initiativePhone;
    }

    public String getPassivityPhone() {
        return passivityPhone;
    }

    public void setPassivityPhone(String passivityPhone) {
        this.passivityPhone = passivityPhone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getSumTime() {
        return sumTime;
    }

    public void setSumTime(String sumTime) {
        this.sumTime = sumTime;
    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }

    public String getCallResult() {
        return callResult;
    }

    public void setCallResult(String callResult) {
        this.callResult = callResult;
    }

    @Override
    public String toString() {
        return "Crm{" +
                "id='" + id + '\'' +
                ", initiativePhone='" + initiativePhone + '\'' +
                ", passivityPhone='" + passivityPhone + '\'' +
                ", customerId='" + customerId + '\'' +
                ", callTime='" + callTime + '\'' +
                ", sumTime='" + sumTime + '\'' +
                ", waiterId='" + waiterId + '\'' +
                ", callResult='" + callResult + '\'' +
                '}';
    }
}