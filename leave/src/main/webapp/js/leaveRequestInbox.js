/**
 * 
 */
function getLeaveRequestList(){
	$.get("http://localhost:8081/api/v1/leave/3090/leaveRequestList", function(data, status){
		var tbodyInnerHtml="";
        for(var i=0;i<data.length;i++){
        	tbodyInnerHtml=tbodyInnerHtml+"<tr><td>"+data[i].id+"</td><td>"+data[i].fromDate+"</td><td>"+data[i].toDate+"</td<td>"+
        	data[i].requestorId+"_"+data[i].requestorName+"</td><td>"+
        	data[i].reason+"</td><tr>";
        }
        $("#leaveRequestInboxTable tbody").html(tbodyInnerHtml);
    });
}