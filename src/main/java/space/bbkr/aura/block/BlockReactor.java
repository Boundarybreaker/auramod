package space.bbkr.aura.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import space.bbkr.aura.Aura;
import space.bbkr.aura.tileentity.TileEntityReactor;

import javax.annotation.Nullable;


public class BlockReactor extends BlockMachine<TileEntityReactor> {
    private static final PropertyDirection FACING = PropertyDirection.create("f");
    public static final PropertyInteger MODE = PropertyInteger.create("m", 0, 1);

    public BlockReactor() {
        super(Material.ROCK, "crystal_reactor");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityReactor tile = getTileEntity(world, pos);
            ItemStack heldItem = player.getHeldItem(hand);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking()) {
                if (heldItem.isEmpty()) {
                    player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
                    world.setBlockState(pos, state.withProperty(MODE, 0));
                } else {
                    player.setHeldItem(hand, itemHandler.insertItem(0, heldItem, false));
                    world.setBlockState(pos, state.withProperty(MODE, 1));
                }
                tile.markDirty();
            } else {
                ItemStack stack = itemHandler.getStackInSlot(0);
                if (!stack.isEmpty()) {
                    String localized = Aura.proxy.localize(stack.getUnlocalizedName() + ".name");
                    player.sendMessage(new TextComponentString(stack.getCount() + "x" + localized));
                } else {
                    player.sendMessage(new TextComponentString("empty"));
                }
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityReactor tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public Class<TileEntityReactor> getTileEntityClass() {
        return TileEntityReactor.class;
    }

    @Nullable
    @Override
    public TileEntityReactor createTileEntity(World world, IBlockState state) {
        return new TileEntityReactor();
    }

    @Override
    public IBlockState getStateForPlacement(World w, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)).withProperty(MODE, 0);
    }

    @Override
    public void onBlockPlacedBy(World w, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        w.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
    }

    @Override public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(MODE, meta % 2).withProperty(FACING, EnumFacing.VALUES[(meta / 2) % 6]);
    }

    @Override public int getMetaFromState(IBlockState state) {
        return state.getValue(MODE) + (2 * state.getValue(FACING).getIndex());
    }

    @Override public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override public IBlockState withMirror(IBlockState state, Mirror mir) {
        return state.withRotation(mir.toRotation(state.getValue(FACING)));
    }

    @Override protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, MODE);
    }
}