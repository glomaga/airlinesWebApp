package cs545.airline.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import cs545.airline.dao.AirplaneDao;
import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;

@Named
@ApplicationScoped
@Transactional
public class AirplaneService  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// These services should be evaluated to reconsider which methods should be public 

	@Inject
	private AirplaneDao airplaneDao;

	
	public void create(Airplane airplane) {
		airplaneDao.create(airplane);
	}

	public void delete(Airplane airplane) {
		airplaneDao.delete(airplane);
	}

	public Airplane update(Airplane airplane) {
		return airplaneDao.update(airplane);
	}

	public Airplane find(Airplane airplane) {
		return airplaneDao.findOne(airplane.getId());
	}

	public Airplane findBySrlnr(String serialno) {
		return airplaneDao.findOneBySerialnr(serialno);
	}

	public List<Airplane> findByFlight(Flight flight) {
		if(flight!= null){
		return airplaneDao.findByFlight(flight.getId());}
		else{
			return null;
		}
	}

	public List<Airplane> findByModel(String model) {
		return airplaneDao.findByModel(model);
	}

	public List<Airplane> findAll() {
		return airplaneDao.findAll();
	}
	
	//ADDED
	public Airplane findById(long id) {
		return airplaneDao.findOneById(id);
	}
	
	//need GET to be able to use
	public Collection<Airplane> getAllAirplane() {
		return airplaneDao.findAll();
	}
	
	public List<Airplane> getFindByFlight(Flight flight) {
		return this.getFindByFlight(flight);
	}
}
