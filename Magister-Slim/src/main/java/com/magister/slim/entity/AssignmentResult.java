package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.AssignmentReference;
import com.magister.slim.references.AssignmentResultReference;
import com.magister.slim.references.StudentReference;

@Document
public class AssignmentResult {

	@Id
	private int assignmentResultId;
	private StudentReference studentReference;
	private List<AssignmentResultReference> assignmentReference;
	private int assignedMarks;
	private int totalmarks;

	public int getAssignmentResultId() {
		return assignmentResultId;
	}

	public void setAssignmentResultId(int assignmentResultId) {
		this.assignmentResultId = assignmentResultId;
	}

	public StudentReference getStudentReference() {
		return studentReference;
	}

	public void setStudentReference(StudentReference studentReference) {
		this.studentReference = studentReference;
	}

	public List<AssignmentResultReference> getAssignmentReference() {
		return assignmentReference;
	}

	public void setAssignmentReference(List<AssignmentResultReference> list) {
		this.assignmentReference = list;
	}

	public int getAssignedMarks() {
		return assignedMarks;
	}

	public void setAssignedMarks(int assignedMarks) {
		this.assignedMarks = assignedMarks;
	}

	public int getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}

	@Override
	public String toString() {
		return "AssignmentResult [assignmentResultId=" + assignmentResultId + ", studentReference=" + studentReference
				+ ", assignmentReference=" + assignmentReference + ", assignedMarks=" + assignedMarks + ", totalmarks="
				+ totalmarks + "]";
	}

	public AssignmentResult(int assignmentResultId, StudentReference studentReference,
			List<AssignmentResultReference> assignmentReference, int assignedMarks, int totalmarks) {
		super();
		this.assignmentResultId = assignmentResultId;
		this.studentReference = studentReference;
		this.assignmentReference = assignmentReference;
		this.assignedMarks = assignedMarks;
		this.totalmarks = totalmarks;
	}
	public AssignmentResult()
	{
		
	}
	

}
