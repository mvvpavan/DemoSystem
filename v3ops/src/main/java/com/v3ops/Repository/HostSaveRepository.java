package com.v3ops.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.v3ops.Model.HostNames;


public interface HostSaveRepository extends CrudRepository<HostNames, Long>{
	  List<HostNames> findByGroupnameAndHostname(String groupname,String hostname);
      HostNames save(HostNames hostnames);
}
