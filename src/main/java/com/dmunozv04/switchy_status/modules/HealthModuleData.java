package com.dmunozv04.switchy_status.modules;

import folk.sisby.switchy.api.SwitchySerializable;
import com.dmunozv04.switchy_status.SwitchyStatus;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class HealthModuleData implements SwitchySerializable {
	public static final String KEY_HEALTH_VALUE = "healthValue";

	protected static final Identifier ID = new Identifier(SwitchyStatus.ID, "health");
	protected float healthValue;

	@Override
	public NbtCompound toNbt() {
		NbtCompound outNbt = new NbtCompound();
		outNbt.putFloat(KEY_HEALTH_VALUE, healthValue);
		return outNbt;
	}

	@Override
	public void fillFromNbt(NbtCompound nbt) {
		healthValue = nbt.getInt(KEY_HEALTH_VALUE);
	}
}
