package com.dmunozv04.switchy_status.modules;

import folk.sisby.switchy.api.SwitchySerializable;
import com.dmunozv04.switchy_status.SwitchyStatus;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class HungerModuleData implements SwitchySerializable {
	public static final String KEY_FOOD_LEVEL = "foodLevel";
	public static final String KEY_FOOD_SATURATION_LEVEL = "foodSaturationLevel";
	public static final String KEY_EXHAUSTION = "exhaustion";
	public static final String KEY_FOOD_TICK_TIMER = "foodTickTimer";
	public static final String KEY_PREV_FOOD_LEVEL = "prevFoodLevel";
	protected static final Identifier ID = new Identifier(SwitchyStatus.ID, "hunger");
	protected int foodLevel = 20;
	protected float foodSaturationLevel;
	protected float exhaustion;
	protected int foodTickTimer;
	protected int prevFoodLevel = 20;

	@Override
	public NbtCompound toNbt() {
		NbtCompound outNbt = new NbtCompound();
		outNbt.putInt(KEY_FOOD_LEVEL, foodLevel);
		outNbt.putFloat(KEY_FOOD_SATURATION_LEVEL, foodSaturationLevel);
		outNbt.putFloat(KEY_EXHAUSTION, exhaustion);
		outNbt.putInt(KEY_FOOD_TICK_TIMER, foodTickTimer);
		outNbt.putInt(KEY_PREV_FOOD_LEVEL, prevFoodLevel);
		return outNbt;
	}

	@Override
	public void fillFromNbt(NbtCompound nbt) {
		foodLevel = nbt.getInt(KEY_FOOD_LEVEL);
		foodSaturationLevel = nbt.getFloat(KEY_FOOD_SATURATION_LEVEL);
		exhaustion = nbt.getFloat(KEY_EXHAUSTION);
		foodTickTimer = nbt.getInt(KEY_FOOD_TICK_TIMER);
		prevFoodLevel = nbt.getInt(KEY_PREV_FOOD_LEVEL);
	}
}
