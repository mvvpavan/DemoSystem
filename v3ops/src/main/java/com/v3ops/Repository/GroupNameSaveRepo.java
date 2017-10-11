package com.v3ops.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.v3ops.Model.GroupNames;

public interface GroupNameSaveRepo extends CrudRepository<GroupNames, Long>{
    List<GroupNames> findByGroupname(String groupnames);
	GroupNames save(GroupNames groupname);

}
