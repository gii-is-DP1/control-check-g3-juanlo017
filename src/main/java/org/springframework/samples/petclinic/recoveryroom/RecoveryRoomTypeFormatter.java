package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType> {

	private final RecoveryRoomService recoveryRoomService;

	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService rService) {
		this.recoveryRoomService = rService;
	}

	@Override
	public String print(RecoveryRoomType recoveryRoomType, Locale locale) {
		return recoveryRoomType.getName();
	}

	@Override
	public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
		RecoveryRoomType rType = this.recoveryRoomService.getRecoveryRoomType(text);
		if(rType != null) return rType;
		else throw new ParseException("type not found: " + text, 0);
	}

}
