package openblocks.common.container;

import net.minecraft.inventory.IInventory;
import openblocks.common.tileentity.TileEntityPaintMixer;

public class ContainerPaintMixer extends ContainerInventory<TileEntityPaintMixer> {

	public ContainerPaintMixer(IInventory playerInventory, TileEntityPaintMixer stainer) {
		super(playerInventory, stainer);
		addSlotToContainer(new RestrictedSlot(inventory, 0, 133, 36));
		addSlotToContainer(new RestrictedSlot(inventory, 1, 115, 72));
		addSlotToContainer(new RestrictedSlot(inventory, 2, 133, 72));
		addSlotToContainer(new RestrictedSlot(inventory, 3, 151, 72));
		addPlayerInventorySlots(110);
	}
}