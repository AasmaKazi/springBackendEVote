package com.sampleDemo.demoProject.repository;

import com.sampleDemo.demoProject.modal.VoterInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterInfoRepository extends JpaRepository<VoterInfo,Integer> {

}
