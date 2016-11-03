package com.sree.leave.model;

public class LeaveRequest {
Double id;
Long fromDate;
Long toDate;
String requestorName;
String requestorId;
String approverId;
String approverName;
String reason;
public Double getId() {
    return id;
}
public void setId(Double id) {
    this.id = id;
}
public Long getFromDate() {
    return fromDate;
}
public void setFromDate(Long fromDate) {
    this.fromDate = fromDate;
}
public Long getToDate() {
    return toDate;
}
public void setToDate(Long toDate) {
    this.toDate = toDate;
}
public String getRequestorName() {
    return requestorName;
}
public void setRequestorName(String requestorName) {
    this.requestorName = requestorName;
}
public String getRequestorId() {
    return requestorId;
}
public void setRequestorId(String requestorId) {
    this.requestorId = requestorId;
}
public String getApproverId() {
    return approverId;
}
public void setApproverId(String approverId) {
    this.approverId = approverId;
}
public String getApproverName() {
    return approverName;
}
public void setApproverName(String approverName) {
    this.approverName = approverName;
}
public String getReason() {
    return reason;
}
public void setReason(String reason) {
    this.reason = reason;
}



}
