package com.example.JOBSHOP.JOBSHOP.services;


import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JOBSHOP.JOBSHOP.Base.BaseService;
import com.example.JOBSHOP.JOBSHOP.errors.RecordNotFoundException;
import com.example.JOBSHOP.JOBSHOP.errors.duplicatedRecordException;
import com.example.JOBSHOP.JOBSHOP.models.Application;
import com.example.JOBSHOP.JOBSHOP.models.Employer;
import com.example.JOBSHOP.JOBSHOP.models.Post;
import com.example.JOBSHOP.JOBSHOP.repositories.employerRepository;

@Service
public class employerService{

	@Autowired
	private employerRepository employerRepository;
	
	@Autowired
	private postService postService;
	
	
	
    
	public Employer insert(Employer employer)
	{
		if (!employer.getEmail().isEmpty() && employer.getEmail() !=null) 
		{
			Optional<Employer> emp = findByEmail(employer.getEmail());
			
				if (emp.isPresent()) 
				{
					throw new duplicatedRecordException("this Email already exist");
				}

		}
		return employerRepository.save(employer);
	}
	
	public Employer getReferenceById(Long id)
	{
		return employerRepository.getReferenceById(id);
	}
   
	public List<Employer> findAll()
	{
		return employerRepository.findAll();
	}
	
	
	public Employer findById(Long id)
	{
		Optional<Employer> finded=employerRepository.findById(id);
		if(finded.isPresent())
		{
			return finded.get();
		}else 
		{
			throw new RecordNotFoundException("employer with id :" + id + "not found");
		}
		
	}
	
//	public void updateEntityStatus(Application t)
//	{
//		applicationRepository.updateEntity(t.getId(),t.getStatusCode()); 
//	}
	
	public Employer update(Employer t)
	{
		if(getReferenceById(t.getId())!=null)
		{
//			logInfo("Employer Updated Successfully");
			return employerRepository.save(t);
		}else 
		{
			throw new RecordNotFoundException("employer with id :" + t + "doesn't exist to update");
		}
	}
	
	public void deleteById(Long id)
	{
		Employer t=getReferenceById(id);
		if(t!=null)
		{
			employerRepository.deleteById(id);
		}
		else 
		{
			throw new RecordNotFoundException("employer with id :" + id + "doesn't exist to delete");
		}
	}
	
	public Post createAPost(Post post)
	{
		return postService.insert(post);
	}

	public List<Post> findPostsByEmployerId(Long id)
	{
		Optional<Employer> finded=employerRepository.findById(id);
		if(finded.isPresent())
	{
			return postService.findByEmployerId(id);
	}else 
	{
		throw new RecordNotFoundException("no employer with id :" + id );
	}
	}
	public List<Employer> findAllWithCompanyAdministrator(Long id)
	{
		return employerRepository.findByCompanyAdministratorId(id);
	}
	

	 public Employer insertPicture(Long id,byte[] picture)
	 {
	try {
		Optional<Employer> employerUpdate=employerRepository.findById(id);
		 if(employerUpdate.isPresent())
		 {
			 System.out.println("Job Seeker :" +employerUpdate.get().getEmail());
			 Employer employerForUpdate=employerUpdate.get();
			 employerForUpdate.setPicture(picture);
			 return employerRepository.save(employerForUpdate);
		 }else  
		 {
			 return null;
		 }
	} catch (Exception e) {
		return null;
	}
	 }
	 
	 private Optional<Employer> findByEmail(String email){
		 return employerRepository.findByEmail(email);
	 }
}
