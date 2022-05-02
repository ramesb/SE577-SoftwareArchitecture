package com.boot.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.jpa.h2.model.Repo;
import com.boot.spring.jpa.h2.repository.DataRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RepoController {

	@Autowired
	DataRepository dataRepository;

	@GetMapping("/repos")
	public ResponseEntity<List<Repo>> getAllRepos(@RequestParam(required = false) String title) {
		try {
			List<Repo> repos = new ArrayList<Repo>();

			if (title == null)
				dataRepository.findAll().forEach(repos::add);
			else
				dataRepository.findByTitleContaining(title).forEach(repos::add);

			if (repos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(repos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/repos/{id}")
	public ResponseEntity<Repo> getRepoById(@PathVariable("id") long id) {
		Optional<Repo> repoData = dataRepository.findById(id);

		if (repoData.isPresent()) {
			return new ResponseEntity<>(repoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/repos")
	public ResponseEntity<Repo> createRepo(@RequestBody Repo repo) {
		try {
			Repo _repo = dataRepository
					.save(new Repo(repo.getTitle(), repo.getDescription(), false));
			return new ResponseEntity<>(_repo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/repos/{id}")
	public ResponseEntity<Repo> updateRepo(@PathVariable("id") long id, @RequestBody Repo repo) {
		Optional<Repo> repoData = dataRepository.findById(id);

		if (repoData.isPresent()) {
			Repo _repo = repoData.get();
			_repo.setTitle(repo.getTitle());
			_repo.setDescription(repo.getDescription());
			_repo.setPublished(repo.isPublished());
			return new ResponseEntity<>(dataRepository.save(_repo), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/repos/{id}")
	public ResponseEntity<HttpStatus> deleteRepo(@PathVariable("id") long id) {
		try {
			dataRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/repos")
	public ResponseEntity<HttpStatus> deleteAllRepos() {
		try {
			dataRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/repos/published")
	public ResponseEntity<List<Repo>> findByPublished() {
		try {
			List<Repo> repos = dataRepository.findByPublished(true);

			if (repos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(repos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
