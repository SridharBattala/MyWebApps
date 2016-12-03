

package com.sree.leave.model;


public class LeaveRequest {
    private String id;
    private Long fromDate;
    private Long toDate;
    private String requestorName;
    private String requestorId;
    private String approverId;
    private String approverName;
    private String reason;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Long getFromDate() {
        return fromDate;
    }

    public void setFromDate(final Long fromDate) {
        this.fromDate = fromDate;
    }

    public Long getToDate() {
        return toDate;
    }

    public void setToDate(final Long toDate) {
        this.toDate = toDate;
    }

    public String getRequestorName() {
        return requestorName;
    }

    public void setRequestorName(final String requestorName) {
        this.requestorName = requestorName;
    }

    public String getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(final String requestorId) {
        this.requestorId = requestorId;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(final String approverId) {
        this.approverId = approverId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(final String approverName) {
        this.approverName = approverName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }



}
