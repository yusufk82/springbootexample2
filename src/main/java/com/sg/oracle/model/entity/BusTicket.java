package com.sg.oracle.model.entity;



import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "BUS_TICKETS")
@SequenceGenerator(name="TICKET_ID_SEQUENCE",sequenceName = "TICKET_ID_SEQ",initialValue = 11,allocationSize = 1)
public class BusTicket
{
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TICKET_ID_SEQUENCE")
    @Column(name = "TICKET_ID")
    private Integer ticketID;
	   
    private String company;
	
    @Column(name = "FROM_PLACE")
    private String fromPlace;
    
    @Column(name = "TO_PLACE")
    private String toPlace;

    @Column(name = "DEPARTURE_TIME")
    private Date departureTime;

	@Column(name = "TCKN")
	private String tckn;

	public Integer getTicketID() {
		return ticketID;
	}

	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getTckn() {
		return tckn;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	@Override
	public String toString() {
		return "BusTicket [ticketID=" + ticketID + ", company=" + company + ", fromPlace=" + fromPlace + ", toPlace="
				+ toPlace + ", departureTime=" + departureTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticketID == null) ? 0 : ticketID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusTicket other = (BusTicket) obj;
		if (ticketID == null) {
			if (other.ticketID != null)
				return false;
		} else if (!ticketID.equals(other.ticketID))
			return false;
		return true;
	}
    
    
	
}
