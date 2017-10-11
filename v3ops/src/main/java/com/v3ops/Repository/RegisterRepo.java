package com.v3ops.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.v3ops.Model.Register;

public interface RegisterRepo extends CrudRepository<Register, Long>{
	List<Register> findByusername(String username);
	List<Register> findByUsernameAndPassword(String username, String password);
	Register save(Register register);
}