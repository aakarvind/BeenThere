package beenthere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beenthere.model.HelpdeskQuery;

@Entity
@Table(name = "queries")
@GenericGenerator(name = "queryIdGen", strategy = "increment")
public class QueriesEntity {
	@Id
	@Column(name = "query_id")
	@GeneratedValue(generator = "queryIdGen")
	private Integer queryId;
	
	@Column(name = "query_subject")
	private String querySubject;

	@Column(name = "query_body")
	private String query;
	
	@Column(name = "query_status")
	private String queryStatus;
	
	@Column(name = "user_id")
	private String userId;
	
	//constructors
	public QueriesEntity(){}

	public QueriesEntity(HelpdeskQuery model){
		setQuery(model.getQuery());
		setQueryStatus(model.getQueryStatus());
		setQuerySubject(model.getQuerySubject());
		setUserId(model.getUserId());
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
