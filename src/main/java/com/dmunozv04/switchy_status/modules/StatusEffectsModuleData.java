package com.dmunozv04.switchy_status.modules;

import com.dmunozv04.switchy_status.SwitchyStatus;
import folk.sisby.switchy.api.SwitchySerializable;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collection;

public class StatusEffectsModuleData implements SwitchySerializable {
	public static final String KEY_STATUS_EFFECTS = "status_effects";
	protected static final Identifier ID = new Identifier(SwitchyStatus.ID, "status_effects");
	protected final Collection<StatusEffectInstance> statusEffectInstanceList = new ArrayList<>();


	@Override
	public NbtCompound toNbt() {
		NbtCompound outNbt = new NbtCompound();
		NbtList statusEffectsList = new NbtList();
		for(StatusEffectInstance statusEffectInstance : statusEffectInstanceList) {
			statusEffectsList.add(statusEffectInstance.writeNbt(new NbtCompound()));
		}
		outNbt.put(KEY_STATUS_EFFECTS, statusEffectsList);
		return outNbt;
	}

	@Override
	public void fillFromNbt(NbtCompound nbt) {
		NbtList statusEffectsList = nbt.getList(KEY_STATUS_EFFECTS, NbtElement.COMPOUND_TYPE);

		for(int i = 0; i < statusEffectsList.size(); ++i) {
			NbtCompound nbtCompound = statusEffectsList.getCompound(i);
			StatusEffectInstance statusEffectInstance = StatusEffectInstance.fromNbt(nbtCompound);
			if (statusEffectInstance != null) {
				statusEffectInstanceList.add(statusEffectInstance);
			}
		}
	}
}
