package com.sg.oracle.model.service;

import com.sg.oracle.model.entity.BusTicket;
import com.sg.oracle.model.repository.BusTicketRepository;
import com.sg.oracle.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusTicketService implements EntityService<BusTicket>
{
    @Autowired
    private BusTicketRepository repository;

    @Override
    public List<BusTicket> findAll()
    {
        return repository.findAll();
    }

    @Override
    public BusTicket save(BusTicket entity)
    {
        try
        {
           return repository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralException(e);
            return null;
        }
    }
}
