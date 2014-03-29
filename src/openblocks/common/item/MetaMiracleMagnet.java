package openblocks.common.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import openblocks.Config;

public class MetaMiracleMagnet extends MetaGeneric {

	public interface ITurtleLister {
		public void addTurtles(List<ItemStack> result);
	}

	public static ITurtleLister lister;

	public MetaMiracleMagnet(String name, Object... recipes) {
		super(name, recipes);
	}

	@Override
	public void registerIcons(IconRegister register) {
		registerIcon(register, "crane_magnet"); // reuse!
	}

	@Override
	public boolean hasEffect(int renderPass) {
		return true;
	}

	@Override
	public void addToCreativeList(int itemId, int meta, List<ItemStack> result) {
		super.addToCreativeList(itemId, meta, result);

		if (Config.enableCraneTurtles && Config.showCraneTurtles && lister != null) {
			lister.addTurtles(result);
		}
	}
}
