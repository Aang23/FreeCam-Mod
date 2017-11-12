package free.cam.mod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;


@Mod(modid = Main.modId, name = Main.name, version = Main.version, acceptedMinecraftVersions = "[1.9.4]")
public class Main {

	public static final String modId = "freecammod";
	public static final String name = "FreeCam";
	public static final String version = "1.0";
	public static int timeout = 0;
	@Mod.Instance(modId)
	public static Main instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		EventBus fus = MinecraftForge.EVENT_BUS;
		fus.register(new KeyPress());
		fus.register(new TickHandler());
		fus.register(new RenderEvent());
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent e)
	{
           
	}
}