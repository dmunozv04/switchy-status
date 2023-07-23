package com.dmunozv04.switchy_status.mixin;

import net.minecraft.entity.player.HungerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
@Mixin(HungerManager.class)
public interface HungerManagerAccessor {
	@Accessor
	void setFoodTickTimer(int foodTickTimer);
	@Accessor
	int getFoodTickTimer();
	@Accessor
	void setPrevFoodLevel(int prevFoodLevel);
}
