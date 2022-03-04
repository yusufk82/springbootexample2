package com.sg.oracle.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.sg.oracle.model.entity.BusTicket;
import com.sg.oracle.model.repository.BusTicketRepository;

/*
 *  View Scope xhtml sayfamizda Ajax kullanildiginda kullanisli olmaktadir. -> Primefaces
 * 
 * Eger bean’in sadece sayfa boyunca yasamasini istersek bu durumda ViewScoped kullanabiliriz.
 * 
 *  @Inject instead of Spring’s @Autowired to inject a bean.
	@Named instead of Spring’s @Component to declare a bean.
 * 
 *  https://stackoverflow.com/questions/5415261/what-is-javax-inject-named-annotation-supposed-to-be-used-for
 */

@SessionScoped
@Named
public class BusTicketController implements Serializable {

	private BusTicket busTicket = new BusTicket();
	private List<BusTicket> busTicketList = new ArrayList<BusTicket>();

	@Autowired
	private BusTicketRepository busTicketRepository;

	public String edit(BusTicket busTicket) {
		this.busTicket = busTicket;
		return "bus_ticket?faces-redirect=true";
	}

	public void fetchAll() {
		busTicketList = busTicketRepository.findAll();
	}

	public String  save() {
		busTicketRepository.save(busTicket); // yapilandirilan bilet kaydedildi

		busTicket = new BusTicket(); // onceki bilet bilgileri yeni olusuturulani etkilemesin

	 // veri eklendeikten sonra, veri tablosunda gosterilmek uzere
														// veriler cekildi.

		return "index?faces-redirect=true";
	}

	public void refresh() {
		busTicket = new BusTicket();
	}

	public BusTicket getBusTicket() {
		return busTicket;
	}

	public void setBusTicket(BusTicket busTicket) {
		this.busTicket = busTicket;
	}

	public List<BusTicket> getBusTicketList() {
		busTicketList = busTicketRepository.findAll();
		return busTicketList;
	}

	public void setBusTicketList(List<BusTicket> busTicketList) {
		this.busTicketList = busTicketList;
	}

	public void setBusTicketRepository(BusTicketRepository busTicketRepository) {
		this.busTicketRepository = busTicketRepository;
	}

}
