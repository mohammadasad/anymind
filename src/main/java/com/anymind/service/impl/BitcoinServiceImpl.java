package com.anymind.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.anymind.dao.BitcoinDao;
import com.anymind.entity.ApiResponse;
import com.anymind.entity.BitcoinDTO;
import com.anymind.service.BitcoinService;

@Transactional
@Service
public class BitcoinServiceImpl implements BitcoinService {

	private static final Logger logger  = LogManager.getLogger(BitcoinServiceImpl.class);
	
	@Autowired
	BitcoinDao bitcoinDao;
	
	@Override
	@Async("threadPoolTaskExecutor")
	public ApiResponse saveBitcoin(BitcoinDTO bitcoinDTO) {
		if(logger.isDebugEnabled())
			logger.debug("BitcoinServiceImpl.saveBitcoin():::Start::");
		   bitcoinDao.save(bitcoinDTO);
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ApiResponse(200, "Successfully Insert", null);
	}
	@Override
	public List<BitcoinDTO> getBitcoinHourly() {
		if(logger.isDebugEnabled())
			logger.debug("BitcoinServiceImpl.getBitcoinHourly():::Start::");
	
		 List<BitcoinDTO> blist= bitcoinDao.findAllByDateTime();
		return blist;
	}
	
}
