package trf.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class TrainingRequestForm {
	int trfID;
	int verID;
	int venID;
	int ttID;
	String trfProjectID;
	String technology;
	String trainingObjectives;
	Date dateRequested;
	Date proposedEndDate;
	String projectSPOC;
	int appxEmployees;
	String requestorEmpID;
	String fileLocation;
	int trainingSource;
	
	public int getTrfID() {
		return trfID;
	}
	public void setTrfID(int trfID) {
		this.trfID = trfID;
	}
	public int getVerID() {
		return verID;
	}
	public void setVerID(int verID) {
		this.verID = verID;
	}
	public int getVenID() {
		return venID;
	}
	public void setVenID(int venID) {
		this.venID = venID;
	}
	public int getTtID() {
		return ttID;
	}
	public void setTtID(int ttID) {
		this.ttID = ttID;
	}
	public String getTrfProjectID() {
		return trfProjectID;
	}
	public void setTrfProjectID(String trfProjectID) {
		this.trfProjectID = trfProjectID;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getTrainingObjectives() {
		return trainingObjectives;
	}
	public void setTrainingObjectives(String trainingObjectives) {
		this.trainingObjectives = trainingObjectives;
	}

	public String getProjectSPOC() {
		return projectSPOC;
	}
	public void setProjectSPOC(String projectSPOC) {
		this.projectSPOC = projectSPOC;
	}
	public int getAppxEmployees() {
		return appxEmployees;
	}
	public void setAppxEmployees(int appxEmployees) {
		this.appxEmployees = appxEmployees;
	}
	public String getRequestorEmpID() {
		return requestorEmpID;
	}
	public void setRequestorEmpID(String requestorEmpID) {
		this.requestorEmpID = requestorEmpID;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public int getTrainingSource() {
		return trainingSource;
	}
	public void setTrainingSource(int trainingSource) {
		this.trainingSource = trainingSource;
	}
	public Date getDateRequested() {
		return dateRequested;
	}
	public Date getProposedEndDate() {
		return proposedEndDate;
	}
	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}
	public void setProposedEndDate(Date proposedEndDate) {
		this.proposedEndDate = proposedEndDate;
	}
}
