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
import net.minecraft.client.resources.I18n;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import space.bbkr.aura.Aura;
import space.bbkr.aura.tileentity.TileEntitySmokestack;

import javax.annotation.Nullable;

public class BlockSmokestack extends BlockMachine<TileEntitySmokestack> {
    public BlockSmokestack() {
        super(Material.ROCK, "smokestack");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntitySmokestack tile = getTileEntity(world, pos);
            ItemStack heldItem = player.getHeldItem(hand);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking()) {
                if (heldItem.isEmpty()) {
                    player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
                } else {
                    player.setHeldItem(hand, itemHandler.insertItem(0, heldItem, false));
                }
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
        TileEntitySmokestack tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

    //@Override
    //public List<String> getDisplayInfo(World world, BlockPos pos, IBlockState state) {
    //    ArrayList<String> text = new ArrayList<String>();
    //    text.add(I18n.format("aura.note.start"));
    //    return text;
    //}

    @Override
    public Class<TileEntitySmokestack> getTileEntityClass() {
        return TileEntitySmokestack.class;
    }

    @Nullable
    @Override
    public TileEntitySmokestack createTileEntity(World world, IBlockState state) {
        return new TileEntitySmokestack();
    }
}
