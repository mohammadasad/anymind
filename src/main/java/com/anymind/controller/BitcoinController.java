package com.anymind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anymind.entity.ApiResponse;
import com.anymind.entity.BitcoinDTO;
import com.anymind.service.BitcoinService;

@RestController
@RequestMapping("/bitcoin")
public class BitcoinController {
	
	@Autowired
	BitcoinService bitcoinService;
	
	// this api will be used to save bicoin
	@PostMapping("/saveBitcoin")
	public ApiResponse saveBitcoin(@RequestBody BitcoinDTO bitCoinDTO){
		return bitcoinService.saveBitcoin(bitCoinDTO);
	}
	// this api will be called from client (UI) on each hours 
	// this will give result on hourly basis of previous history 
	// it will give total accumulated amount on hourly basis
	@GetMapping("/getBitcoin")
	public List<BitcoinDTO> getBitcoin(){
		return bitcoinService.getBitcoinHourly();
	}

}
