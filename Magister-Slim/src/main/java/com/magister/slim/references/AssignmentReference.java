package com.magister.slim.references;

public class AssignmentReference {
	
	private int assignmentId;
	private String assignmentName;
	public int getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	@Override
	public String toString() {
		return "AssignmentReference [assignmentId=" + assignmentId + ", assignmentName=" + assignmentName + "]";
	}
	
}
