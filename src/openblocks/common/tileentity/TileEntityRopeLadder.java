package openblocks.common.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import openblocks.OpenBlocks;
import openblocks.common.api.IAwareTile;

public class TileEntityRopeLadder extends OpenTileEntity implements IAwareTile {

	@Override
	public void onBlockPlacedBy(EntityPlayer player, ForgeDirection side, ItemStack stack, float hitX, float hitY, float hitZ) {
		setRotation(side.getOpposite());
		sync();
		if (!worldObj.isRemote) {
			int y = yCoord;
			while (y-- > 0) {
				if (worldObj.isAirBlock(xCoord, y, zCoord) && OpenBlocks.Blocks.ropeLadder.canPlaceBlockOnSide(worldObj, xCoord, y, zCoord, getRotation())) {
					worldObj.setBlock(xCoord, y, zCoord, getBlockType().blockID, getMetadata(), 3);
				}else {
					return;
				}
			}
		}
	}

	@Override
	public boolean onBlockActivated(EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onBlockBroken() {
		if (worldObj.isRemote) return;
		int y = yCoord;
		while (y-- > 0) {
			TileEntity te = worldObj.getBlockTileEntity(xCoord, y, zCoord);
			if (te instanceof TileEntityRopeLadder) {
				worldObj.setBlockToAir(xCoord, y, zCoord);
			}else {
				 return;
			}
		}
	}

	@Override
	public void onBlockAdded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNeighbourChanged(int blockId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onBlockEventReceived(int eventId, int eventParam) {
		// TODO Auto-generated method stub
		return false;
	}

}