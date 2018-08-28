package co.com.ceiba.estacionamiento.services;

import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.converter.ConvertMTE;
import co.com.ceiba.estacionamiento.domain.Watchman;
import co.com.ceiba.estacionamiento.entity.RegisterEntity;
import co.com.ceiba.estacionamiento.exceptions.ParkingException;
import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;

@Service
public class RegisterServiceImplement implements IRegisterService {
	
	@Autowired
	private IRegisterRepository registerRepository;
	
	private Watchman v;
	
	@PostConstruct
	public void initRepository () {
		v = new Watchman(registerRepository);
	}	

	@Override
	@Transactional(readOnly = true)
	public List<RegisterEntity> getListRegister() {
		try {
			return (List<RegisterEntity>) registerRepository.findAll();	
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}		
	}

	@Override
	@Transactional
	public RegisterEntity saveRegister(RegisterEntity register) {
		try {
			Register registerModel = ConvertMTE.convertEntityToModel(register);
			v.validateInRegister(registerModel);
			return registerRepository.save(register);
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public void deleteRegister(Long id) {
		try {
			registerRepository.deleteById(id);
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public RegisterEntity updatedRegister(RegisterEntity register, Long id) {
		try {
			RegisterEntity registerUpdate = findById(id);
			registerUpdate.setId(register.getId());
			registerUpdate.setPlaca(register.getPlaca());
			registerUpdate.setCilindraje(register.getCilindraje());
			registerUpdate.setTipo(register.getTipo());
			return registerRepository.save(registerUpdate);			
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public RegisterEntity findById(Long id) {
		try {
			return registerRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}	

	@Override
	@Transactional
	public RegisterEntity calculateFee(Long id) {
		try {
			RegisterEntity registerUpdate = findById(id);
			registerUpdate.setFechaSalida(LocalDateTime.now());
			Register registerModel = ConvertMTE.convertEntityToModel(registerUpdate);
			v.calculo(registerModel);
			return registerRepository.save(ConvertMTE.convertModelToEntity(registerModel));			
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}


}
