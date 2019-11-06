package com.magister.slim.references;

public class GroupReference {
	
	private int groupId;
	private String groupName;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "GroupReference [groupId=" + groupId + ", groupName=" + groupName + "]";
	}
	

}
