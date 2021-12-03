package mrsup2044.earlymilitary;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EarlyMilitary implements ModInitializer {
    // an instance of our new item

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("tutorial", "general"), () -> new ItemStack(Blocks.GOLD_BLOCK));

    public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("tutorial", "other"))
            .icon(() -> new ItemStack(Items.GOLDEN_SHOVEL))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(Blocks.BONE_BLOCK));
                stacks.add(new ItemStack(Items.APPLE));
                stacks.add(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER));
                stacks.add(ItemStack.EMPTY);
                stacks.add(new ItemStack(Items.IRON_SHOVEL));
            })
            .build();

    public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));


    public static final Item FABRIC_ITEM = new Item(new FabricItemSettings().group(EarlyMilitary.ITEM_GROUP));
    public static final Item Another_ITEM = new Item(new FabricItemSettings().group(EarlyMilitary.OTHER_GROUP));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric_item"), FABRIC_ITEM);
        Registry.register(Registry.ITEM, new Identifier("test","test1"), Another_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings().group(EarlyMilitary.ITEM_GROUP)));
    }
}
