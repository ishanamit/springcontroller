package org.stack.main.repocontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class RepoService {
    List<Repos> repos = new ArrayList<>(Arrays.asList(
            new Repos("R1","ishan","java"),
            new Repos("R2","agni","spring"),
            new Repos("R3","agniswar","bootstrap")          
            ));
    
    public List<Repos> getAllRepos() {
        return repos;
    }
    
    public Repos getRepos(String id) {
        return repos.stream().filter(e -> e.getRepoId().equals(id)).findFirst().get();
    }
    
    public boolean addRepos(Repos repo,String id) {
    	for(Repos e : repos) {
            if(e.getRepoId().equals(id)) {
                return true;
                
            }
            
    	}
    	repos.add(repo);
		return false;
    }
    public boolean updateRepos(String id, Repos repo) {
        for(Repos e : repos) {
            if(e.getRepoId().equals(id)) {
                return true;
            }               
        }
		return false;
        
    }
    public boolean deleteRepos(String id,Repos repo) {
    	for(Repos e : repos) {
            if(e.getRepoId().equals(id)) {
                return true;
            }               
        }
		return false;
        
        
    }
}