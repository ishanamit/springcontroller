package org.stack.main.repocontroller;

public class Repos {
	private String RepoId;
	private String username;
	private String language;
	
	public String getRepoId() {
		return RepoId;
	}
	public void setRepoId(String repoId) {
		RepoId = repoId;
	}
	public Repos()
	{
		super();
	}
	public Repos(String repoId)
	{
		super();
		RepoId=repoId;
	}
	public Repos(String repoId, String username, String language) {
		super();
		RepoId = repoId;
		this.username = username;
		this.language = language;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
    
}
