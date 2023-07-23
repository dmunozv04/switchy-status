package com.dmunozv04.switchy_status.modules;

import folk.sisby.switchy.api.SwitchyEvents;
import folk.sisby.switchy.api.module.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class HealthModule extends HealthModuleData implements SwitchyModule, SwitchyModuleTransferable, SwitchyEvents.Init {
	@Override
	public void updateFromPlayer(ServerPlayerEntity player, @Nullable String nextPreset) {
		healthValue = player.getHealth();
	}

	@Override
	public void applyToPlayer(ServerPlayerEntity player) {
		player.setHealth(healthValue);
	}

	@Override
	public void onInitialize() {
		SwitchyModuleRegistry.registerModule(ID, HealthModule::new, new SwitchyModuleInfo(
			false,
			SwitchyModuleEditable.OPERATOR,
			Text.translatable("switchy.status.module.health.description"))
			.withDescriptionWhenEnabled(Text.translatable("switchy.status.module.health.enabled"))
			.withDescriptionWhenDisabled(Text.translatable("switchy.status.module.health.disabled"))
			.withDeletionWarning(Text.translatable("switchy.status.module.health.warning"))
		);
	}
}
