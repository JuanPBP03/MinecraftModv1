package init;

import com.myname.tutorial.Reference;

import items.ItemBasic;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems 
	{

	static Item tutorialItem;
	static Item testItem;
	
	public static void init() {
		tutorialItem = new ItemBasic("tutorialItem").setCreativeTab(CreativeTabs.MATERIALS).setMaxStackSize(16);
		testItem = new ItemBasic("testItem").setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) 
	{
		
		event.getRegistry().registerAll(tutorialItem);
		event.getRegistry().registerAll(testItem);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(tutorialItem);
		registerRender(testItem);
	}
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
