package beenthere.model;

import beenthere.entity.QueriesEntity;

public class HelpdeskQuery {
	private Integer queryId;
	private String querySubject;
	private String query;
	private String queryStatus;
	private String userId;
	
	//constructors
	public HelpdeskQuery(){}
	
	public HelpdeskQuery(QueriesEntity entity){
		setQuery(entity.getQuery());
		setQueryId(entity.getQueryId());
		setQueryStatus(entity.getQueryStatus());
		setQuerySubject(entity.getQuerySubject());
		setUserId(entity.getUserId());
	}
	
	public Integer getQueryId() {
		return queryId;
	}
	public void setQueryId(Integer queryId) {
		this.queryId = queryId;
	}
	public String getQuerySubject() {
		return querySubject;
	}
	public void setQuerySubject(String querySubject) {
		this.querySubject = querySubject;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQueryStatus() {
		return queryStatus;
	}
	public void setQueryStatus(String queryStatus) {
		this.queryStatus = queryStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
