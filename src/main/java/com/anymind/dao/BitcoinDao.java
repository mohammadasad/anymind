package com.anymind.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anymind.entity.BitcoinDTO;

@Repository
public interface BitcoinDao extends JpaRepository<BitcoinDTO, Integer> {

	@Query("select new com.anymind.entity.BitcoinDTO(sum(amount),datetime) from BitcoinDTO group by date_part('hour', datetime), datetime")
	List<BitcoinDTO> findAllByDateTime();
	
}
