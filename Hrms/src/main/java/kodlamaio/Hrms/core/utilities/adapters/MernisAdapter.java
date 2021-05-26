package kodlamaio.Hrms.core.utilities.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.fakeMernisService.FakeMernisManager;

@Service
public class MernisAdapter  implements MernisService {
	
	@Autowired
	FakeMernisManager fakeMernisManager;
	
	@Override
	public boolean isOkay(String identityNumber) {
		return this.fakeMernisManager.isOkay(identityNumber);
	}


	
}
