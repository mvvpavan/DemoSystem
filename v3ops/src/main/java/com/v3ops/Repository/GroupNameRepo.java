package com.v3ops.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.v3ops.Model.GroupNames;

public interface GroupNameRepo extends CrudRepository<GroupNames, Long>{

	List<GroupNames> findAll();

}
