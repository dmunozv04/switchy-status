package com.dmunozv04.switchy_status.modules;

import folk.sisby.switchy.api.SwitchyEvents;
import folk.sisby.switchy.api.module.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class StatusEffectsModule extends StatusEffectsModuleData implements SwitchyModule, SwitchyModuleTransferable, SwitchyEvents.Init {
	@Override
	public void updateFromPlayer(ServerPlayerEntity player, @Nullable String nextPreset) {
		statusEffectInstanceList.clear();
		statusEffectInstanceList.addAll(player.getStatusEffects());

	}

	@Override
	public void applyToPlayer(ServerPlayerEntity player) {
		player.clearStatusEffects();
		for(StatusEffectInstance statusEffectInstance : statusEffectInstanceList) {
			player.addStatusEffect(statusEffectInstance);
		}
	}

	@Override
	public void onInitialize() {
		SwitchyModuleRegistry.registerModule(ID, StatusEffectsModule::new, new SwitchyModuleInfo(
				false,
				SwitchyModuleEditable.OPERATOR,
				Text.translatable("switchy.status.module.status_effects.description"))
				.withDescriptionWhenEnabled(Text.translatable("switchy.status.module.status_effects.enabled"))
				.withDescriptionWhenDisabled(Text.translatable("switchy.status.module.status_effects.disabled"))
				.withDeletionWarning(Text.translatable("switchy.status.module.status_effects.warning"))
		);
	}
}
