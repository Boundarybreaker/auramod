package space.bbkr.aura.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.tileentity.TileEntity;
import space.bbkr.aura.Aura;

import javax.annotation.Nullable;


public abstract class BlockMachine<TE extends TileEntity> extends BlockBase {

    public BlockMachine(Material material, String name) {
        super(material, name);

        setCreativeTab(Aura.creativeTab);
    }

    public abstract Class<TE> getTileEntityClass();

    public TE getTileEntity(IBlockAccess world, BlockPos pos) {
        return (TE)world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public abstract TE createTileEntity(World world, IBlockState state);

    @Override
    public BlockMachine setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

}

