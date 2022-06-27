package com.anymind.service;

import java.util.List;

import com.anymind.entity.ApiResponse;
import com.anymind.entity.BitcoinDTO;

public interface BitcoinService {
	ApiResponse saveBitcoin(BitcoinDTO bitcoinDTO);
	List<BitcoinDTO> getBitcoinHourly();
}
