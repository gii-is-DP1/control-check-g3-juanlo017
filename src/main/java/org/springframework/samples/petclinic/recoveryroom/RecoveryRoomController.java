package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class RecoveryRoomController {
	private static final String VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	private final RecoveryRoomService recoveryRoomService;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}
	
	@ModelAttribute("types")
	public List<RecoveryRoomType> populatePetTypes() {
		return this.recoveryRoomService.getAllRecoveryRoomTypes();
	}
	
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom room = new RecoveryRoom();
		model.put("recoveryRoom", room);
		return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom room, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("recoveryRoom", room);
			return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.recoveryRoomService.save(room);
			return "welcome";
		}
	}
}
