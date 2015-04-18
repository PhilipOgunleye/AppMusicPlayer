package com.philip.model;

public class User {
	private int userid;
	private String title;
    private int startTime;
    private int endTime;
    private int day;
    
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getStartTime() {
        return startTime;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public int getEndTime() {
        return endTime;
            
    }
    public void setEndTime(int i) {
        this.endTime = i;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", title=" + title
                + ", startTime=" + startTime + ", endTime=" + endTime + ", day="
                + day + "]";
    }
	public void setStartTime(String parameter) {
		// TODO Auto-generated method stub
		
	}
	public void setEndTime(String parameter) {
		// TODO Auto-generated method stub
		
	}
	public void setDay(String parameter) {
		// TODO Auto-generated method stub
		
	}    

}
