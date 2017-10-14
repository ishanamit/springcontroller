package org.stack.main.repocontroller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
public class RepoController {
    @Autowired
    private RepoService repoService;
    
    @GetMapping("/repos")
    public List<Repos> getAllSavedRepos() {
        return repoService.getAllRepos();
    }   
    @GetMapping("/repos/{id}")
    public ResponseEntity getRepo(@PathVariable(value="id") String id) {
        
        return new ResponseEntity<Repos>(repoService.getRepos(id), HttpStatus.OK);

    }   
    @PostMapping("/repos")
    public ResponseEntity<String> addRepo(@RequestBody Repos repo,@PathVariable String id) {
        if(repoService.addRepos(repo,id))
        {
        	return new ResponseEntity<String>("Repo already exists!",HttpStatus.CONFLICT);
        }
    else
        	return new ResponseEntity<String>("Repo successfully added!",HttpStatus.CREATED);
    }
    @PutMapping("/repos/{id}")
    public ResponseEntity<String> updateRepos(@RequestBody Repos repo, @PathVariable(value= "id") String id) {
    	
    	
    	if(repoService.updateRepos(id,repo))
        {
        	return new ResponseEntity<String>("Repo updated!",HttpStatus.OK);
        }
        else
        	return new ResponseEntity<String>("Repo does not exist!",HttpStatus.CONFLICT);
    }
    
    @DeleteMapping("/repos/{id}")
    public ResponseEntity<String> deleteRepos(@PathVariable(value="id") String id,@RequestBody Repos repo) {
    	if(repoService.deleteRepos(id,repo))
        {
        	return new ResponseEntity<String>("Repo deleted!",HttpStatus.OK);
        }
        else
        	return new ResponseEntity<String>("Repo does not exist!",HttpStatus.CONFLICT);
    }
}