package com.sampleDemo.demoProject.controller;

import com.sampleDemo.demoProject.SendSMS;
import com.sampleDemo.demoProject.repository.VoterInfoRepository;
import com.sampleDemo.demoProject.modal.VoterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class VoterController {
    @Autowired
    private SendSMS sendSMS;

    @Autowired
    private VoterInfoRepository voterRepo;


    @PostMapping(value = "/register")
    public ResponseEntity<?> registerVoter(@RequestBody VoterInfo voterInfo){
        ResponseEntity entity=null;
        VoterInfo info=(VoterInfo) voterRepo.save(voterInfo);
        entity = new ResponseEntity(info, HttpStatus.OK);
        return entity;
    }

    @GetMapping(value = "/getAllData")
    public ResponseEntity<?> registerVoter(){
        ResponseEntity entity=null;
        VoterInfo info=(VoterInfo) voterRepo.findAll();
        entity = new ResponseEntity(info, HttpStatus.OK);
        return entity;
    }

    @PostMapping(value= "/sendOPT")
    public String sendOTP(@RequestBody VoterInfo info){
        Random random=new Random();
        double randomNum = Math.random();

        sendSMS.sendSms(info.getContactNumber(),info.getEmail() +" opt is "+ randomNum);
        return "OPT Sent";
    }

}
