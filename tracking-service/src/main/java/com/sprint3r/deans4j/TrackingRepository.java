package com.sprint3r.deans4j;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TrackingRepository extends CrudRepository<Tracking, Long> {

	Optional<Tracking> findByOrderId(Long orderId);
	List<Tracking> findAllByOrderId(Long orderId);
	
}