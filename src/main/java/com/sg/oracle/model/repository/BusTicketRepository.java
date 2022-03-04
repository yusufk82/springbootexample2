package com.sg.oracle.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.oracle.model.entity.BusTicket;

public interface BusTicketRepository extends JpaRepository<BusTicket, Integer>
{

}
