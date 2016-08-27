package gaia.block;

import gaia.Gaia;
import gaia.tileentity.TileEntityDollSlimeGirl;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDollSlimeGirl extends BlockContainer {

	public BlockDollSlimeGirl(Material par2Material) {
		super(par2Material);
		//this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
		this.setLightOpacity(0);
		this.setHardness(3.0F);
		this.setResistance(6.0F);
		this.setUnlocalizedName("GrimoireOfGaia.DollSlimeGirl");
		this.setCreativeTab(Gaia.tabGaia);
	}

	/** TODO BOUNDS**/
	protected static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BOUNDS;
    }
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }
    
	public TileEntity createNewTileEntity(World par1World, int i) {
		return new TileEntityDollSlimeGirl();
	}

	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
		if (entity != null) {
			TileEntityDollSlimeGirl tile = (TileEntityDollSlimeGirl)world.getTileEntity(pos);
			tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		}
	}

	public Block setBlockTextureName(String string) {
		return null;
	}
}
