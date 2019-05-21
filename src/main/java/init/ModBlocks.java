package init;

import com.myname.tutorial.Reference;
import com.myname.tutorial.blocks.BlockOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {

	static Block rubyOre;
	
	public static void init() {
			rubyOre = new BlockOre("rubyOre", Material.ROCK, ModItems.tutorialItem, 1).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHardness(1.5f);
			rubyOre.setHarvestLevel("pickaxe", 2); 
	}
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		 event.getRegistry().registerAll(rubyOre);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(rubyOre).setRegistryName(rubyOre.getRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(rubyOre));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
		
	}
	
}
