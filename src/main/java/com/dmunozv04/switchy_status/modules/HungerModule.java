package com.dmunozv04.switchy_status.modules;

import com.dmunozv04.switchy_status.mixin.HungerManagerAccessor;
import folk.sisby.switchy.api.SwitchyEvents;
import folk.sisby.switchy.api.module.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class HungerModule extends HungerModuleData implements SwitchyModule, SwitchyModuleTransferable, SwitchyEvents.Init {
	@Override
	public void updateFromPlayer(ServerPlayerEntity player, @Nullable String nextPreset) {
		foodLevel = player.getHungerManager().getFoodLevel();
		foodSaturationLevel = player.getHungerManager().getSaturationLevel();
		exhaustion = player.getHungerManager().getExhaustion();
		foodTickTimer = ((HungerManagerAccessor) player.getHungerManager()).getFoodTickTimer();
		prevFoodLevel = player.getHungerManager().getPrevFoodLevel();
	}

	@Override
	public void applyToPlayer(ServerPlayerEntity player) {
		player.getHungerManager().setFoodLevel(foodLevel);
		player.getHungerManager().setSaturationLevel(foodSaturationLevel);
		player.getHungerManager().setExhaustion(exhaustion);
		((HungerManagerAccessor) player.getHungerManager()).setFoodTickTimer(foodTickTimer);
		((HungerManagerAccessor) player.getHungerManager()).setPrevFoodLevel(prevFoodLevel);
	}

	@Override
	public void onInitialize() {
		SwitchyModuleRegistry.registerModule(ID, HungerModule::new, new SwitchyModuleInfo(
				false,
				SwitchyModuleEditable.OPERATOR,
				Text.translatable("switchy.status.module.hunger.description.description"))
				.withDescriptionWhenEnabled(Text.translatable("switchy.status.module.hunger.description.enabled"))
				.withDescriptionWhenDisabled(Text.translatable("switchy.status.module.hunger.description.disabled"))
				.withDeletionWarning(Text.translatable("switchy.status.module.hunger.description.warning"))
		);
	}
}
