package com.dmunozv04.switchy_status;

import folk.sisby.switchy.api.SwitchyEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwitchyStatus implements SwitchyEvents.Init {
	public static final String ID = "switchy_status";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {

	}
}
